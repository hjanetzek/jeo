/* Copyright 2013 The jeo project. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jeo.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class VersionTest {

    @Test
    public void testCompare() {
        Version v = new Version(1,2,3);
        assertEquals(1, v.compareTo(new Version(0,2,3)));
        assertEquals(1, v.compareTo(new Version(1,0,3)));
        assertEquals(1, v.compareTo(new Version(1,2,0)));

        assertEquals(-1, v.compareTo(new Version(2,2,3)));
        assertEquals(-1, v.compareTo(new Version(1,3,3)));
        assertEquals(-1, v.compareTo(new Version(1,2,4)));

        assertEquals(0, v.compareTo(new Version(1,2,3)));
    }

    @Test
    public void testEquals() {
        assertEquals(new Version(1,2,3), new Version(1,2,3));
    }

    @Test
    public void testParse() {
        assertEquals(new Version(1,2,3), new Version("1.2.3"));
        assertEquals(new Version(1,2,0), new Version("1.2"));
        assertEquals(new Version(1,0,0), new Version("1"));
    }
}
