<%@page import="ProjectB.DB"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.mysql.jdbc.jdbc2.optional.MysqlDataSource"%>
<!doctype html>
<%
    javax.servlet.http.HttpSession sesion = request.getSession();
    String username = ((String) sesion.getAttribute("username"));
    DB subjects = new DB();
    subjects.connect();
    //String subjectJAVA = subjects.subjectsJAVA().getString("subjectname");
   // String subjectPLSQL = subjects.subjectsPLSQL().getString("subjectname");
%>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

        <title>Project B - <%=username%> </title>
        <meta name="description" content="Project B - Discover, Learn, CODE!!">
        <meta name="author" content="Borja Lagaron @borjonudo">

        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="css/bootstrap.css">
        <style>
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
        </style>
        <link rel="stylesheet" href="css/bootstrap-responsive.css">
        <link rel="stylesheet" href="css/style.css">

        <script src="js/libs/modernizr-2.5.3-respond-1.1.0.min.js"></script>
    </head>
    <body>
        <!--[if lt IE 7]><p class=chromeframe>Your browser is <em>ancient!</em> <a href="http://browsehappy.com/">Upgrade to a different browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to experience this site.</p><![endif]-->

        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">Project B</a>
                    <div class="nav-collapse pull-right">
                        <ul class="nav">
                            <form class="navbar-search pull-left">
                                <input type="text" class="search-query" placeholder="Search">
                            </form>
                            <li><a href="index.jsp">Home</a></li>
                            <li><a href="#">Courses</a></li>
                            <li><a href="#">Top</a></li>
                            <li><a href="#">Create</a></li>
                            <li class="active"><a href="#"><%=username%></a></li>
                            <li><a href="logout.jsp">Log out</a></li> 
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <div class="container">
            <div>
                <h1>JAVA</h1>
                <div>
                    <ul>
                         <li>
                         <h3>Introduccion</h3>
                         </li>
                         <li>
                         <h3>Tema 2</h3>
                         </li>

                    </ul>
                </div>
                <h1>PL/SQL</h1>
                <div>
                    <ul>
                         <li>
                         <h3>Introduccion PL SQL</h3>
                         </li><li>
                         <h3>Tema 2 PL SQL</h3>
                         </li>

                    </ul>
                </div>
            </div>

                <hr>

                <footer class="footer">
                    <div>
                        <p class=pull-right>
                            <a href="#">Back to top</a>
                        </p>
                        <ul>
                            <li>&copy;2012 Project B</li>
                            <li><a href="/about">About</a></li>
                            <li><a href="mailto:contact@projectb.com">Contact Us</a></li>
                        </ul>
                    </div>
                </footer>

            </div> <!-- /container -->
            <script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
            <script>window.jQuery || document.write('<script src="js/libs/jquery-1.7.1.min.js"><\/script>')</script>

            <script src="js/libs/bootstrap/transition.js"></script>
            <script src="js/libs/bootstrap/collapse.js"></script>

            <script src="js/script.js"></script>
            <script>
                var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
                (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
                    g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
                    s.parentNode.insertBefore(g,s)}(document,'script'));
            </script>

    </body>
</html>