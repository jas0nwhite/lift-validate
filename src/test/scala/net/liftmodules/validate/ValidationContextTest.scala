/*
 * Copyright 2014 E-Terra Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.liftmodules.validate

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import net.liftmodules.validate.Validators._
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._

class ValidationContextTest extends FlatSpec with ContextTest with Matchers with MockitoSugar {

  "ValidationContext" should behave like anyContext(ValidationContext())

  it should "call validators on validating" in {
    val v1 = mock[Validator[String]]
    val v2 = mock[Validator[String]]

    val ctx = ValidationContext()
    ctx.addValidator(v1)
    ctx.addValidator(v2)
    ctx.validate

    verify(v1).validate
    verify(v2).validate
  }
}
