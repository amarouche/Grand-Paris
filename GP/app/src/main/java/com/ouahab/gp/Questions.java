package com.ouahab.gp;

import java.util.ArrayList;
/**
 * Created by Idir on 02/05/2017.
 */

public class Questions {

    public String [] myQuestions = {
            "Dans ce château vécut Louis XIV, roi de France au XVII ème siècle : le roi Soleil. Ce château est " + "célèbre pour ses jardins, ses fontaines et sa galerie des glaces.",

            "C’est le plus grand aéroport de France. Son nom vient de la commune de Roissy en France et" + " du général de Gaule qui fut Président de la République française.",
            "Construit en 1998 pour la coupe du monde de football afin de remplacer le Parc des Princes, c’est le plus grand stade français avec ses 81 338 places : il accueille de nombreux matchs, des concerts et spectacles.",
            "C’est le grand aéroport au sud de Paris, le deuxième aéroport de France pour prendre l’avion à destination de la France, l’Europe, le Maghreb, le Moyen-Orient et les DOM-TOM français.",
            "Ce parc contient de nombreux sites agricoles, des châteaux, des églises, des manoirs et des forêts, dont une partie du domaine de Rambouillet. Ses nombreux sentiers de grande randonnée permettent de découvrir ces nombreux sites.",
            "C’est le plus grand musée aéronotiquede France ; il occupe une partie de l’aéroport du Bourget. Il est situé sur deux zones : l’ancienne aérogare sur 125 000 m2 et 130 000 m2, sur une ancienne base de l’Armée de l’Air de l’autre côté de l’aéroport, à Dugny.",
            "Cette basilique est le plus grand musée au monde de monuments funéraires : elle habrite les tombeaux de nombreux rois et reines de France ; on peut y découvrir aussi des gisants : des sculptures qui les représentent couchés",
            "Ce bâtiment se trouvait à l’origine aux Coeur des halles de Paris : en 1972 il a été déplacé en Seine et Marne. Il accueille aujourd’hui des spectacles, des salons ou des emissions de television comme par exemple la Nouvelle Star.",
            "Le Musée d'Art Contemporain du VAL-de-Marne le premier musée d'art contemporain installé à Vitry-sur-Seine. En 2015, il accueille la première exposition consacrée au Grand Paris Express, le futur métro de la métropole parisienne. ",
            "Ce parc est situé sur quatre communes de Saint Cloud, Marnes la Coquette, Sèvres et Garches. Depuis1923 il est protégé et est considéré, avec ses 460 hectares, comme l'un des plus beaux jardins d'Europe."
    };


    private String [][] myChoices = {
            {"LE CHÂTEAU DE VERSAILLES", "LE PARC DE SAINT CLOUD", "LE PAVILLON BALTARD", "LE MUSÉE DE L’AIR ET DE L’ESPACE"},
            {"L’AÉROPORT D’ORLY", "LE PARC DE LA CHEVREUSE", "L’AÉROPORT ROISSY CHARLES DE GAULE", "LE MUSEE MAC VAL"},
            {"LA BASILIQUE SAINT DENIS", "LE STADE DE FRANCE", "LE PARC DE LA CHEVREUSE", "LE CHÂTEAU DE VERSAILLES"},
            {"LE LOUVRE", "PARC DES PRINCES", "ARC DE TRIOMPHE", "L’AÉROPORT D’ORLY"},
            {"MUSEE D'ORSAY", "LE PARC DE LA CHEVREUSE", "TOUR EIFFEL", "SAINTE-CHAPELLE"},
            {"LE MUSÉE DE L’AIR ET DE L’ESPACE", "PARC MONCEAU", "MUSEE RODIN", "CANAL SAINT-MARTIN"},
            {"PANTHEON", "PONT ALEXANDRE-III", "PLACE DE LA BASTILLE", "LA BASILIQUE SAINT DENIS"},
            {"LE PAVILLON BALTARD", "JARDIN DES TUILERIES", "PLACE DES VOSGES", "GRAND PALAIS"},
            {"MUSEE D'ORSAY", "MUSEE JACQUEMART-ANDRE", "MUSEE MARMOTTAN MONET", "LE MUSEE MAC VAL"},
            {"DISNEYLAND", "PARC DE LA CONCORDE", "LE PARC DE SAINT CLOUD", "PETIT PALAIS"}
    };


    private String [] myCorrectAnswers = {
            "LE CHÂTEAU DE VERSAILLES",
            "L’AÉROPORT ROISSY CHARLES DE GAULE",
            "LE STADE DE FRANCE",
            "L’AÉROPORT D’ORLY",
            "LE PARC DE LA CHEVREUSE",
            "LE MUSÉE DE L’AIR ET DE L’ESPACE",
            "LA BASILIQUE SAINT DENIS",
            "LE PAVILLON BALTARD",
            "LE MUSEE MAC VAL",
            "LE PARC DE SAINT CLOUD"
    };


    public String getQuestion(int a) {
        String question = myQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice = myChoices[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = myChoices[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = myChoices[a][2];
        return choice;
    }

    public String getChoice4(int a) {
        String choice = myChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a) {
        String correctAnswer = myCorrectAnswers[a];
        return correctAnswer;
    }


}

