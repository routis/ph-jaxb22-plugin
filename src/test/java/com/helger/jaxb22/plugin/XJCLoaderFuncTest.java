/**
 * Copyright (C) 2014-2018 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.jaxb22.plugin;

import java.io.File;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import com.helger.commons.io.file.FileHelper;
import com.sun.tools.xjc.Driver;

public final class XJCLoaderFuncTest
{
  @Test
  public void testLoadXJC () throws Throwable
  {
    try (final PrintStream aPS = new PrintStream (FileHelper.getOutputStream (new File ("target/jaxb22-test.txt")),
                                                  true,
                                                  StandardCharsets.UTF_8.name ()))
    {
      // Don't use Driver.main because it calls System.exit
      Driver.run (new String [] { new File ("src/test/resources/changelog-1.0.xsd").getAbsolutePath (),
                                  "-d",
                                  new File ("target").getAbsolutePath () },
                  aPS,
                  aPS);
    }
  }
}
