/*
 * Copyright 2010-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.codegen;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestSuite;

import java.io.File;
import java.util.regex.Pattern;
import org.jetbrains.jet.JetTestUtils;
import org.jetbrains.jet.test.InnerTestClasses;
import org.jetbrains.jet.test.TestMetadata;

import org.jetbrains.jet.codegen.AbstractCheckLocalVariablesTableTest;

/** This class is generated by {@link org.jetbrains.jet.generators.tests.GenerateTests}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/checkLocalVariablesTable")
public class CheckLocalVariablesTableTestGenerated extends AbstractCheckLocalVariablesTableTest {
    public void testAllFilesPresentInCheckLocalVariablesTable() throws Exception {
        JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.GenerateTests", new File("compiler/testData/checkLocalVariablesTable"), Pattern.compile("^(.+)\\.kt$"), true);
    }
    
    @TestMetadata("sharedVarNames.kt")
    public void testSharedVarNames() throws Exception {
        doTest("compiler/testData/checkLocalVariablesTable/sharedVarNames.kt");
    }
    
    @TestMetadata("someClass.kt")
    public void testSomeClass() throws Exception {
        doTest("compiler/testData/checkLocalVariablesTable/someClass.kt");
    }
    
    @TestMetadata("_DefaultPackage$foo$1.kt")
    public void test_DefaultPackage$foo$1() throws Exception {
        doTest("compiler/testData/checkLocalVariablesTable/_DefaultPackage$foo$1.kt");
    }
    
    @TestMetadata("_DefaultPackage$foo$1$1.kt")
    public void test_DefaultPackage$foo$1$1() throws Exception {
        doTest("compiler/testData/checkLocalVariablesTable/_DefaultPackage$foo$1$1.kt");
    }
    
    @TestMetadata("_DefaultPackage$foo$a$1.kt")
    public void test_DefaultPackage$foo$a$1() throws Exception {
        doTest("compiler/testData/checkLocalVariablesTable/_DefaultPackage$foo$a$1.kt");
    }
    
    @TestMetadata("_DefaultPackage$foo1$1.kt")
    public void test_DefaultPackage$foo1$1() throws Exception {
        doTest("compiler/testData/checkLocalVariablesTable/_DefaultPackage$foo1$1.kt");
    }
    
}
