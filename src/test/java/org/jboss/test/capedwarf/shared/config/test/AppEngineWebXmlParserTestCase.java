/*
 *
 *  * JBoss, Home of Professional Open Source.
 *  * Copyright 2011, Red Hat, Inc., and individual contributors
 *  * as indicated by the @author tags. See the copyright.txt file in the
 *  * distribution for a full listing of individual contributors.
 *  *
 *  * This is free software; you can redistribute it and/or modify it
 *  * under the terms of the GNU Lesser General Public License as
 *  * published by the Free Software Foundation; either version 2.1 of
 *  * the License, or (at your option) any later version.
 *  *
 *  * This software is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *  * Lesser General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU Lesser General Public
 *  * License along with this software; if not, write to the Free
 *  * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 *  * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 *
 */

package org.jboss.test.capedwarf.shared.config.test;


import java.io.ByteArrayInputStream;

import org.jboss.capedwarf.shared.config.AppEngineWebXml;
import org.jboss.capedwarf.shared.config.AppEngineWebXmlParser;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:marko.luksa@gmail.com">Marko Luksa</a>
 */
public class AppEngineWebXmlParserTestCase {

    @Test
    public void testParse() throws Exception {
        String xml = "<appengine-web-app>" +
                "    <application>appName</application>" +
                "    <version>2</version>" +
                "</appengine-web-app>";

        AppEngineWebXml appEngineWebXml = AppEngineWebXmlParser.parse(new ByteArrayInputStream(xml.getBytes()));

        Assert.assertEquals("appName", appEngineWebXml.getApplication());
        Assert.assertEquals("2", appEngineWebXml.getVersion());
    }

    @Test
    public void testSystemProperties() throws Exception {
        String xml = "<appengine-web-app>" +
                "    <application>appName</application>" +
                "    <version>2</version>" +
                "    <system-properties>" +
                "        <property name=\"foo\" value=\"bar\"/>" +
                "    </system-properties>" +
                "</appengine-web-app>";

        AppEngineWebXmlParser.parse(new ByteArrayInputStream(xml.getBytes()));

        assertEquals("bar", System.getProperty("foo"));
    }


}