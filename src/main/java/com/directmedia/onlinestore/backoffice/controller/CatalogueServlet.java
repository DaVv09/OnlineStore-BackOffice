package com.directmedia.onlinestore.backoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CatalogueServlet", urlPatterns = {"/catalogue"})
public class CatalogueServlet extends HttpServlet {
    private Object Work;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        Work lucyInTheSky=new Work("Lucy in the Sky");
        Artist nataliePortman=new Artist("Natalie Portman");
        lucyInTheSky.setMainArtist(nataliePortman);
        lucyInTheSky.setGenre("Drame");
        lucyInTheSky.setRelease(2020);
        lucyInTheSky.setSummary("Une jeune femme, engagée comme nounou de deux orphelins, est convaincue que le manoir dans lequel ils vivent est hanté. Adaptation de la nouvelle Le Tour d'écrou écrite par Henry James.");

        Work badBoysForLife=new Work("Bad boys for life");
        Artist willSmith=new Artist("Will Smith");
        badBoysForLife.setMainArtist(willSmith);
        badBoysForLife.setGenre("comédie");
        badBoysForLife.setRelease(2020);
        badBoysForLife.setSummary("Les Bad Boys Mike Lowrey et Marcus Burnett se retrouvent pour résoudre une ultime affaire.");

        Work theTurning=new Work("The turning");
        Artist mackenzieDavis=new Artist("Mackenzie Davis");
        theTurning.setMainArtist(mackenzieDavis);
        theTurning.setGenre("drame");
        theTurning.setRelease(2020);
        theTurning.setSummary("Une jeune femme, engagée comme nounou de deux orphelins, est convaincue que le manoir dans lequel ils vivent est hanté. Adaptation de la nouvelle Le Tour d'écrou écrite par Henry James.");

        Catalogue catalogue=new Catalogue();
        catalogue.listOfWorks.add(lucyInTheSky);
        catalogue.listOfWorks.add(badBoysForLife);
        catalogue.listOfWorks.add(theTurning);


        req.setAttribute("listeOeuvre", Catalogue.listOfWorks);
        RequestDispatcher disp=req.getRequestDispatcher("/WEB-INF/catalogue.jsp");
        disp.forward(req,resp);



    }
}


