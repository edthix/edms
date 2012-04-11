(ns edms.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css include-js html5]]))

(defn hello-galaxy [] "hahahhahha")

(defpartial layout [& content]
  (html5
   [:head
    [:meta {:charset "UTF-8"}]
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
    [:meta {:name "description" :content ""}]
    [:meta {:name "author" :content "TRIKOM Studio"}]
    
    [:title "EDMS"]
    
    (include-css "/css/bootstrap.css" "/css/style.css" "/css/bootstrap-responsive.css")]
   
   [:body
    [:div.container

     [:div.navbar.navbar-fixed-top
      [:div.navbar-inner             
       [:div.container-fluid

        [:a.brand {:href "/"} "EDMS"]

        [:div.nav-collapse
         [:ul.nav
          [:li [:a {:href "/documents"} "Documents"]]
          [:li [:a {:href "/"} "Users"]]

          [:li.dropdown
           [:a.dropdown-toggle {:data-toggle "dropdown"} "Reports" [:b.caret "&nbsp;"]]
           [:ul.dropdown-menu
            [:li [:a {:href "#"} "Search"]]
            [:li [:a {:href "#"} "Reports"]]]]        
          ]
         [:p.navbar-text.pull-right "Logged in as " [:a {:href "#"} "username"]]
         ] ;; nav-collapse
        ]]] ;; navbar

     [:div.container-fluid
      [:div.row-fluid
       [:div.span3
        [:div.well.sidebar-nav
         [:ul.nav.nav-list
          [:li.nav-header "Sidebar"]
          [:li [:a {:href "#"} "Menu"]]
          [:li [:a {:href "#"} "Menu"]]
          [:li [:a {:href "#"} "Menu"]]
          [:li [:a {:href "#"} "Menu"]]
          ]]] ;; span3

       [:div.span9
        
        [:div.row-fluid
         content ]
        
        ] ;; span9
       ] ;; row-fluid
      
      [:hr]
      [:footer
       [:div.well
        [:p "2012 - Developed by " [:a {:href "#"} "Trikom Studio."]]]] ;; footer
      ] ;; container-fluid
     ] ;; container
    
    (include-js  "/js/jquery.js" "/js/bootstrap.js")
    ] ;; body
   ))
