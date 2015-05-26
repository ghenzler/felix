/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.felix.http.base.internal.whiteboard;

import org.apache.felix.http.base.internal.context.ExtServletContext;
import org.apache.felix.http.base.internal.handler.ContextHandler;
import org.apache.felix.http.base.internal.registry.PerContextHandlerRegistry;
import org.apache.felix.http.base.internal.runtime.ServletContextHelperInfo;
import org.osgi.framework.Bundle;

public class HttpServiceContextHandler implements ContextHandler, Comparable<ContextHandler>
{
    /** The info object for the context. */
    private final ServletContextHelperInfo info;

    private final PerContextHandlerRegistry registry;

    private final ExtServletContext webContext;

    /** The http bundle. */
    private final Bundle httpBundle;

    public HttpServiceContextHandler(final ServletContextHelperInfo info,
            final PerContextHandlerRegistry registry,
            final ExtServletContext webContext,
            final Bundle httpBundle)
    {
        this.info = info;
        this.registry = registry;
        this.webContext = webContext;
        this.httpBundle = httpBundle;
    }

    @Override
    public ServletContextHelperInfo getContextInfo()
    {
        return this.info;
    }

    @Override
    public int compareTo(final ContextHandler o)
    {
        return this.info.compareTo(o.getContextInfo());
    }

    @Override
    public PerContextHandlerRegistry getRegistry()
    {
        return this.registry;
    }
}
