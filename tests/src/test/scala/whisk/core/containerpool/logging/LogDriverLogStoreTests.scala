/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package whisk.core.containerpool.logging

import akka.actor.ActorSystem
import akka.testkit.TestKit
import org.junit.runner.RunWith
import org.scalatest.FlatSpecLike
import org.scalatest.Matchers
import org.scalatest.junit.JUnitRunner
import whisk.core.containerpool.ContainerArgsConfig

@RunWith(classOf[JUnitRunner])
class LogDriverLogStoreTests extends TestKit(ActorSystem("LogDriverLogStore")) with FlatSpecLike with Matchers {

  val testConfig = ContainerArgsConfig(
    network = "network",
    extraArgs =
      Map("log-driver" -> Set("fluentd"), "log-opt" -> Set("fluentd-address=localhost:24225", "tag=OW_CONTAINER")))
  behavior of "LogDriver LogStore"

  it should "set the container parameters from the config" in {
    val logDriverLogStore = new LogDriverLogStore(system)
    logDriverLogStore.containerParameters shouldBe Map()
  }
}
