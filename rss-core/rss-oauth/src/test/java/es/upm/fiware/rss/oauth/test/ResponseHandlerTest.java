/**
 * Revenue Settlement and Sharing System GE
 * Copyright (C) 2011-2014, Javier Lucio - lucio@tid.es
 * Telefonica Investigacion y Desarrollo, S.A.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package es.upm.fiware.rss.oauth.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.message.BasicStatusLine;
import org.junit.Assert;
import org.junit.Test;

import es.upm.fiware.rss.oauth.service.ResponseHandler;

/**
 * 
 *
 */
public class ResponseHandlerTest {
    /**
     * 
     */
    @Test
    public void handleResponseTest() throws Exception {
        ResponseHandler handler = new ResponseHandler();
        HttpResponseFactory factory = new DefaultHttpResponseFactory();
        HttpResponse responseSent = factory.newHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, HttpStatus.SC_OK,
            "reason"), null);
        HttpResponse response = handler.handleResponse(responseSent);
        Assert.assertEquals(handler.getStatus(), HttpStatus.SC_OK);
        Assert.assertFalse(handler.hasContent());
        // response with content.
        BasicHttpEntity entity = new BasicHttpEntity();
        InputStream inputStream = new ByteArrayInputStream("new content".getBytes());
        entity.setContent(inputStream);
        entity.setContentLength("new content".length()); // sets the length
        response.setEntity(entity);
        response = handler.handleResponse(responseSent);
        Assert.assertEquals("new content", handler.getResponseContent());
    }

}