package com.keithmarsh;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class SausageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Logger log = Logger.getLogger(this.getClass().getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MongoCredential credential = MongoCredential.createCredential("kjm", "mvn-play", "unsafe".toCharArray());
        MongoClient mongo = new MongoClient(new ServerAddress("ds031852.mongolab.com", 31852), Arrays.asList(credential));
        DB db = mongo.getDB("mvn-play");
        DBCollection names = db.getCollection("names");
        DBObject object = names.findOne();
        response.getWriter().println(object.toString());
        response.getWriter().close();
    }
}
