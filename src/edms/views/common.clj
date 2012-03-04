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
                
        [:a.brand {:href "/"} "EDMS"]

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

     [:header
      [:div.well
       [:h1 "Prototype " [:small "24 Feb 2012"]]
       [:p "Prototype for <span class=\"label label-info\">SEDCO</span>. Document Management & Tracking System developed by <span class=\"label label-success\">Trikom Studio</span> based on requirements/specs."]
       [:p [:span.label.label-warning "NOTICE: This is a demonstration and not a fully working system"]]
       ]]
     
     content

     [:footer
      [:div.well
       [:p "2012 - Developed by " [:a {:href "#"} "Trikom Studio."]]]]]
    
    (include-js "/js/bootstrap.min.js")
    ]))
