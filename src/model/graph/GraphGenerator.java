package model.graph;

public class GraphGenerator {
    private static Graph graph = new Graph();

    static {
//        newGraph.addNode("London");
//        newGraph.addNode("Poland");
//        newGraph.addNode("Odessa");
//        newGraph.addNode("Berlin");
//        newGraph.addNode("Korea");
//        newGraph.addNode("Krym");
//        newGraph.addNode("Kipr");
//
//        newGraph.addEdge("Poland", "London", 450);
//        newGraph.addEdge("Odessa", "Poland", 400);
//        newGraph.addEdge("London", "Poland", 360);
//        newGraph.addEdge("Poland", "Odessa", 400);
//        newGraph.addEdge("Odessa","Berlin", 700);
//        newGraph.addEdge("Berlin", "Poland", 600);
//        newGraph.addEdge("Berlin", "Korea", 600);
//        newGraph.addEdge("Krym", "Kipr", 600);
//        newGraph.addEdge("Kipr", "London", 800);
//        newGraph.addEdge("Poland", "Krym", 500);


        graph.addNode("Berlin");   //0
        graph.addNode("Madrid");  //1
        graph.addNode("Rome");  //2
        graph.addNode("Paris");  //3
        graph.addNode("Vienna");  //4
        graph.addNode("Warsaw");  //5
        graph.addNode("Hamburg");  //6
        graph.addNode("Bucharest");  //7
        graph.addNode("Budapest");  //8
        graph.addNode("Barcelona");  //9
        graph.addNode("Munich");  //10
        graph.addNode("Milan");  //11
        graph.addNode("Sofia");  //12
        graph.addNode("Prague");  //13
        graph.addNode("Cologne");  //14
        graph.addNode("Stockholm");  //15
        graph.addNode("Amsterdam");  //16
        graph.addNode("Naples");  //17
        graph.addNode("Marseille");  //18
        graph.addNode("Turin");  //19
        graph.addNode("Kraków");  //20
        graph.addNode("Valencia");  //21
        graph.addNode("Zagreb");  //22
        graph.addNode("Frankfurt");  //23
        graph.addNode("Seville");  //24
        graph.addNode("Zaragoza");  //25
        graph.addNode("Wrocław");  //26
        graph.addNode("Łódź");  //27
        graph.addNode("Rotterdam");  //28
        graph.addNode("Helsinki");  //29
        graph.addNode("Copenhagen");  //30
        graph.addNode("Athens");  //31
        graph.addNode("Stuttgart");  //32
        graph.addNode("Düsseldorf");  //33
        graph.addNode("Riga");  //34
        graph.addNode("Leipzig");  //35
        graph.addNode("Dublin");  //36
        graph.addNode("Gothenburg");  //37
        graph.addNode("Dortmund");  //38
        graph.addNode("Vilnius");  //39
        graph.addNode("Essen");  //40
        graph.addNode("Bremen");  //41
        graph.addNode("Hague");  //42
        graph.addNode("Genoa");  //43
        graph.addNode("Dresden");  //44
        graph.addNode("Poznań");  //45
        graph.addNode("Antwerp");  //46
        graph.addNode("Hanover");  //47
        graph.addNode("Lyon");  //48
        graph.addNode("Nuremberg");  //49
        graph.addNode("Duisburg");  //50
        graph.addNode("Toulouse");  //51
        graph.addNode("Gdańsk");  //52
        graph.addNode("Bratislava");  //53
        graph.addNode("Murcia");  //54
        graph.addNode("Tallinn");  //55
        graph.addNode("Kielce");  //56
        graph.addNode("Szczecin");  //57
        graph.addNode("Bologna");  //58
        graph.addNode("Sintra");  //59
        graph.addNode("Brno");  //60
        graph.addNode("Lisabon");  //61
        graph.addNode("Florence");  //62
        graph.addNode("Bochum");  //63
        graph.addNode("Utrecht");  //64
        graph.addNode("Aarhus");  //65
        graph.addNode("Bilbao");  //66
        graph.addNode("Varna");  //67
        graph.addNode("Alicante");  //68
        graph.addNode("Bydgoszcz");  //69
        graph.addNode("Bielefeld");  //70
        graph.addNode("Lublin");  //71
        graph.addNode("Nantes");  //72
        graph.addNode("Thessaloniki");  //73
        graph.addNode("Münster");  //74
        graph.addNode("Darlsruhe");  //75
        graph.addNode("Kaunas");  //76
        graph.addNode("London");  //77
        graph.addNode("Kyiv");  //78
        graph.addNode("Baku");  //79
        graph.addNode("Kharkiv");  //80
        graph.addNode("Oslo");    //81
        graph.addNode("Podgorica");  //82
        graph.addNode("Tirana");  //83
        graph.addNode("Cairo");  //84
        graph.addNode("Tehran");  //85
        graph.addNode("Istanbul");  //86
        graph.addNode("Bahdad");  //87
        graph.addNode("Ankara");  //88
        graph.addNode("Dubai");  //89
        graph.addNode("Alexandria"); //90
        graph.addNode("Izmir");  //91
        graph.addNode("Zaporizia");  //92
        graph.addNode("Doha");  //93
        graph.addNode("Mecca");  //94
        graph.addNode("Jeddah");  //95
        graph.addNode("Lviv");   //96
        graph.addNode("Odessa");  //97
        graph.addNode("Lutsk");  //98
        graph.addNode("Cherkasy");  //99


        graph.addMultipleEdges("Berlin", "Barcelona Alicante", "492 711");
        graph.addMultipleEdges("Madrid", "Milan Rotterdam Bydgoszcz", "391 510 610 782");
        graph.addMultipleEdges("Rome", "Gdańsk Kielce Ankara", "496 510 580");
        graph.addMultipleEdges("Paris", "Milan Zagreb Rotterdam", "380 750 810");
        graph.addMultipleEdges("Vienna", "Utrecht", "500");
        graph.addMultipleEdges("Warsaw", "Bremen Tallinn Bydgoszcz Podgorica", "420 560 619 450");
        graph.addMultipleEdges("Hamburg", "Budapest Bratislava Bochum Ankara", "290 489 410 672");
        graph.addMultipleEdges("Bucharest", "Hamburg Budapest Athens", "519 480 602");
        graph.addMultipleEdges("Budapest", "Bucharest Murcia Utrecht Bochum Bahdad", "500 494 381 633 545");
        graph.addMultipleEdges("Barcelona", "Berlin Milan Zaragoza Brno Lisabon", "360 740 690 633 545");
        graph.addMultipleEdges("Munich", "Düsseldorf Vilnius Oslo Podgorica Izmir", "623 710 468 399 491");
        graph.addMultipleEdges("Milan", "Munich Genoa Tallinn Alexandria", "529 620 701 455");
        graph.addMultipleEdges("Sofia", "Marseille Hanover Duisburg Sintra", "501 547 603 369");
        graph.addMultipleEdges("Prague", "Bucharest Frankfurt", "369 380");
        graph.addMultipleEdges("Cologne", "Helsinki Hague Lisabon", "820 711 632");
        graph.addMultipleEdges("Stockholm", "Łódź Nantes", "390 472");
        graph.addMultipleEdges("Amsterdam", "Kharkiv Zaporizia", "538 582");
        graph.addMultipleEdges("Naples", "Helsinki Copenhagen Nuremberg Alicante", "390 420 537 628");
        graph.addMultipleEdges("Marseille", "Rotterdam Copenhagen Doha", "590 601 649");
        graph.addMultipleEdges("Turin", "Sofia Dortmund Tallinn", "290 350 632");
        graph.addMultipleEdges("Kraków", "Valencia Toulouse Bologna Bochum", "520 502 640 390");
        graph.addMultipleEdges("Valencia", "Kraków Copenhagen Podgorica Cairo", "472 498 562 605");
        graph.addMultipleEdges("Zagreb", "Bilbao Bahdad Zaporizia", "520 489 597");
        graph.addMultipleEdges("Frankfurt", "Prague Varna", "742 422");
        graph.addMultipleEdges("Seville", "Gdańsk Kielce", "451 601");
        graph.addMultipleEdges("Zaragoza", "Hamburg Barcelona Essen Istanbul", "498 744 397 524");
        graph.addMultipleEdges("Wrocław", "Athens Dresden Baku", "522 498 623");
        graph.addMultipleEdges("Łódź", "Stockholm Nuremberg Lviv", "472 690 383");
        graph.addMultipleEdges("Rotterdam", "Gdańsk Münster", "629 711");
        graph.addMultipleEdges("Helsinki", "Cologne Naples Florence", "591 439 399");
        graph.addMultipleEdges("Copenhagen", "Naples Valencia Toulouse Aarhus", "398 412 509 495");
        graph.addMultipleEdges("Athens", "Bucharest Wrocław Lyon Brno", "701 682 498 525");
        graph.addMultipleEdges("Stuttgart", "Bielefeld Oslo", "385 472");
        graph.addMultipleEdges("Düsseldorf", "Milan Tehran", "625 598");
        graph.addMultipleEdges("Riga", "Munich Kielce", "744 634");
        graph.addMultipleEdges("Leipzig", "Lisabon Bochum", "391 435");
        graph.addMultipleEdges("Dublin", "Bydgoszcz Podgorica", "492 571");
        graph.addMultipleEdges("Gothenburg", "Mecca Dubai", "390 687");
        graph.addMultipleEdges("Dortmund", "Marseille Genoa Thessaloniki", "482 552 612");
        graph.addMultipleEdges("Vilnius", "Munich Sintra", "523 687");
        graph.addMultipleEdges("Essen", "Zaragoza Varna Bydgoszcz Thessaloniki", "621 487 398 625");
        graph.addMultipleEdges("Bremen", "Hamburg Antwerp Varna", "629 565 399");
        graph.addMultipleEdges("Hague", "Cologne Naples Florence", "576 397 691");
        graph.addMultipleEdges("Genoa", "Milan Dortmund Baku", "523 687 355");
        graph.addMultipleEdges("Dresden", "Wrocław Frankfurt", "498 345");
        graph.addMultipleEdges("Poznań", "Sintra Mecca", "554 481");
        graph.addMultipleEdges("Antwerp", "Bremen Gdańsk Bahdad", "529 432 378");
        graph.addMultipleEdges("Hanover", "Sofia Toulouse Florence", "465 723 698");
        graph.addMultipleEdges("Lyon", "Athens Oslo Tehran Dubai", "592 523 465 712");
        graph.addMultipleEdges("Nuremberg", "Naples Łódź Varna", "342 471 297");
        graph.addMultipleEdges("Duisburg", "Sofia Bielefeld", "523 587");
        graph.addMultipleEdges("Toulouse", "Turin Kraków Copenhagen", "587 387 412");
        graph.addMultipleEdges("Gdańsk", "Rome Seville Rotterdam Szczecin", "354 872 481 701");
        graph.addMultipleEdges("Bratislava", "Budapest Bochum", "523 423");
        graph.addMultipleEdges("Murcia", "Riga Cairo", "535 623");
        graph.addMultipleEdges("Tallinn", "Warsaw Milan Marseille Oslo", "387 590 367 429");
        graph.addMultipleEdges("Kielce", "Rome Seville Riga Odessa", "254 385 691 513");
        graph.addMultipleEdges("Szczecin", "Gdańsk Dubai", "487 523");
        graph.addMultipleEdges("Bologna", "Sofia Kraków Baku Dubai", "387 426 512 683");
        graph.addMultipleEdges("Sintra", "Hamburg Sofia Turin Poznań Varna", "465 823 612 399 423");
        graph.addMultipleEdges("Brno", "Barcelona Athens Doha", "523 265 723");
        graph.addMultipleEdges("Lisabon", "Barcelona Cologne Leipzig", "523 745 812");
        graph.addMultipleEdges("Florence", "Helsinki Hague Hanover", "444 528 498");
        graph.addMultipleEdges("Bochum", "Vienna Budapest Kraków Lublin", "472 512 398 642");
        graph.addMultipleEdges("Utrecht", "Budapest Kaunas", "376 498");
        graph.addMultipleEdges("Aarhus", "Copenhagen Lyon", "234 543");
        graph.addMultipleEdges("Bilbao", "Naples Zagreb Gdańsk", "523 478 365");
        graph.addMultipleEdges("Varna", "Zagreb Essen Bremen", "523 432 387");
        graph.addMultipleEdges("Alicante", "Berlin Hamburg Darlsruhe", "523 476 397");
        graph.addMultipleEdges("Bydgoszcz", "Warsaw Dublin Essen", "426 523 365");
        graph.addMultipleEdges("Bielefeld", "Stuttgart Hague Duisburg", "436 479 524");
        graph.addMultipleEdges("Lublin", "Bochum Bielefeld", "587 601");
        graph.addMultipleEdges("Nantes", "Stockholm Bremen", "287 365");
        graph.addMultipleEdges("Thessaloniki", "Dortmund Essen Toulouse", "523 649 379");
        graph.addMultipleEdges("Münster", "Rotterdam Bydgoszcz", "582 496");
        graph.addMultipleEdges("Darlsruhe", "Alicante Istanbul", "712 402");
        graph.addMultipleEdges("Kaunas", "Utrecht Kyiv Alexandria", "487 356 491");
        graph.addMultipleEdges("London", "Nuremberg Alicante Dubai", "512 494 396");
        graph.addMultipleEdges("Kyiv", "Kaunas Tirana", "354 715");
        graph.addMultipleEdges("Baku", "Amsterdam Wrocław Genoa Bologna", "523 487 501 604");
        graph.addMultipleEdges("Kharkiv", "Mecca Alexandria", "523 387");
        graph.addMultipleEdges("Oslo", "Munich Lyon Tallinn", "398 196 498");
        graph.addMultipleEdges("Podgorica", "Warsaw Istanbul Valencia Dublin", "523 474 592 467");
        graph.addMultipleEdges("Tirana", "Izmir Cherkasy", "287 478");
        graph.addMultipleEdges("Cairo", "Zagreb Murcia Tehran", "423 381 714");
        graph.addMultipleEdges("Tehran", "Düsseldorf Lyon Cairo Istanbul", "512 329 401 491");
        graph.addMultipleEdges("Istanbul", "Valencia Podgorica Tehran Mecca Odessa", "712 398 487 299 476");
        graph.addMultipleEdges("Bahdad", "Budapest Zagreb Zaragoza", "435 286 581");
        graph.addMultipleEdges("Ankara", "Rome Sofia", "523 712");
        graph.addMultipleEdges("Dubai", "Bremen Genoa Szczecin Bologna Cherkasy", "523 712 361 723 591");
        graph.addMultipleEdges("Alexandria", "Milan Kaunas Lutsk", "523 612 401");
        graph.addMultipleEdges("Izmir", "Munich Sofia Tirana", "437 572 385");
        graph.addMultipleEdges("Zaporizia", "Zagreb Cherkasy", "379 419");
        graph.addMultipleEdges("Doha", "Naples Brno Lviv", "256 357 484");
        graph.addMultipleEdges("Mecca", "Gothenburg Poznań Kharkiv Istanbul Jeddah", "523 691 385 502 496");
        graph.addMultipleEdges("Jeddah", "Mecca Cairo London", "265 734 623");
        graph.addMultipleEdges("Lviv", "Łódź Hanover Tallinn Doha", "254 487 365 598");
        graph.addMultipleEdges("Odessa", "Kielce Istanbul", "275 481");
        graph.addMultipleEdges("Lutsk", "Izmir Hanover Athens", "254 753 649");
        graph.addMultipleEdges("Cherkasy", "Nuremberg Bahdad ", "486 724");
    }

    public static Graph getGraph() {
        return graph;
    }
}
