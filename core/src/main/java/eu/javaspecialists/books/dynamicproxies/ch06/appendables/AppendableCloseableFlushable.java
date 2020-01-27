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

package eu.javaspecialists.books.dynamicproxies.ch06.appendables;

import eu.javaspecialists.books.dynamicproxies.ch06.*;
import eu.javaspecialists.books.dynamicproxies.util.*;

import java.io.*;
import java.util.*;

// tag::listing[]
public interface AppendableCloseableFlushable
    <E extends Appendable & Closeable & Flushable> extends
    Appendable, Closeable, Flushable, BaseComponent<E> {
  static Map<MethodKey, Reducer> getReducers() {
    return Map.of(
        new MethodKey(Appendable.class, "append",
            CharSequence.class),
        Reducer.PROXY_INSTANCE_REDUCER,
        new MethodKey(Appendable.class, "append",
            CharSequence.class, int.class, int.class),
        Reducer.PROXY_INSTANCE_REDUCER,
        new MethodKey(Appendable.class, "append", char.class),
        Reducer.PROXY_INSTANCE_REDUCER);
  }
}
// end::listing[]
