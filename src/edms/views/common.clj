(ns edms.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css include-js html5]]))

(defpartial layout [& content]
  (html5
   [:head
    [:title "EDMS Prototype"]
    (include-css "/css/bootstrap.min.css" "/css/style.css")    
    ]
   
   [:body
    [:div.container

     [:div.navbar.navbar-fixed-top
      [:div.navbar-inner             
       [:div.container
                
        [:a.brand {:href "/"} "electronic document management system"]

        [:ul.nav
         [:li [:a {:href "/documents"} "Documents"]]
         [:li [:a {:href "/"} "Users"]]
         [:li [:a {:href "/"} "Reports"]]

         [:li.dropdown
          [:a.dropdown-toggle {:data-toggle "dropdown"} "Reports" [:b.caret "&nbsp;"]]
          [:ul.dropdown-menu
           [:li [:a {:href "#"} "Search"]]
           [:li [:a {:href "#"} "Reports"]]]]        
         ]
        
        ]]]

     
     content

     [:footer
      [:div.well
       [:p "2012 - Developed by " [:a {:href "#"} "Trikom Studio."]]]]]
    
    (include-js  "/js/jquery.js" "/js/bootstrap.min.js")
    ]))
