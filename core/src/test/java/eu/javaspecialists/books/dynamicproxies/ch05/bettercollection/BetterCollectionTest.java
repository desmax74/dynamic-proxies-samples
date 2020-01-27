/*
 * Copyright (C) 2020 Heinz Max Kabutz
 *
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.  Heinz Max Kabutz
 * licenses this file to you under the Apache License, Version
 * 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the
 * License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the
 * License.
 */

package eu.javaspecialists.books.dynamicproxies.ch05.bettercollection;

import java.lang.reflect.*;
import java.util.*;

import static junit.framework.TestCase.*;

public class BetterCollectionTest {
  @SuppressWarnings("unchecked,rawtypes")
  protected void test(Collection<String> names) {
    names.add("Wolfgang");
    names.add("Bobby Tables");
    names.add("Leander");
    names.add("Klaus");
    names.add("Menongahela");
    assertEquals(5, names.size());
    assertEquals(String[].class, names.toArray().getClass());
    if (names instanceof Proxy) {
      try {
        ((Collection) names).add(42);
        fail("Should have thrown a ClassCastException");
      } catch (ClassCastException expected) {
      }
    }
    assertTrue(names.toString().startsWith("--["));
    assertTrue(names.toString().endsWith("]--"));
  }

  protected void testDynamic(Collection<String> holder) {
    test(BetterCollectionFactory.asBetterCollection(
        holder, new String[0]));
  }
  protected void testHandCrafted(Collection<String> holder) {
    test(new BetterCollectionObjectAdapter<>(
        holder, new String[0]));
  }
}