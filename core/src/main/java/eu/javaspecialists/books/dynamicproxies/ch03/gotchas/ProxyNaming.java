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

package eu.javaspecialists.books.dynamicproxies.ch03.gotchas;

import eu.javaspecialists.books.dynamicproxies.*;

// tag::listing[]
public class ProxyNaming {
  public interface Public {
    void open();
  }
  interface Hidden {
    void mystery();
  }
  public static void main(String... args) {
    System.out.println(Proxies.simpleProxy(
        Public.class, () -> {}
    ).getClass());
    System.out.println(Proxies.simpleProxy(
        Hidden.class, () -> {}
    ).getClass());
  }
}
// end::listing[]
