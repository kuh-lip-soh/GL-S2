<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <title></title>
        <meta charset="UTF-8">
        <style type="text/css">
            * {
                font-family: 'Montserrat', Arial, Helvetica, sans-serif;
            }

            #tp-div {
                background-color:rgb(228, 228, 228);
                padding: 20px;
                margin: 10px;
                border-radius: 7px;
                width: 400px;
                float: left;
            }
        </style>
    </head>

    <body>
        <%@ include file="WEB-INF/commonJsp.jsp" %>
            <div id="tp-div">
                <a href="">
                    <h1>TP 01</h1>
                </a>
            </div>
            <div id="tp-div">
                <a href="./carnet">
                    <h1>TP 02</h1>
                </a>
                <p>
                    Le but de cet exercice est de mettre en place une application repartie de gestion de carnet
                    d'adresses.
                    Les specifications sont les suivantes :
                </p>
                <ul>
                    - Un carnet d'adresse est definie par son nom et un ensemble d'adresses associees.
                </ul>
                <ul>- L'adresse est une adresse postale representee par : le nom et numero de rue ainsi que le nom de la
                    ville.
                </ul>
                <ul>- Chaque adresse est associee au nom d'une personne.
                </ul>
                <ul>- Le carnet contient un ensemble d'adresses, en plus des methodes :
                </ul>
                <ul>- enregistrer : qui permet d'ajouter une adresse au carnet.
                </ul>
                <ul>- effacer : qui permet de supprimer une adresse.
                </ul>
                <ul>- chercher : qui permet de trouver une adresse dans le carnet.
                </ul>
                <ul>- lister : qui permet d'afficher la liste des adresses.</ul>
            </div>
    </body>

    </html>