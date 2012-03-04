(ns edms.views.main
  (:require [edms.views.common :as common])
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.core :only [html]]
        [hiccup.page-helpers :only [include-js include-css html5]]))

(defpage "/" []
  (html5
   [:head
    [:title "EDMS Prototype"]
    (include-css "/css/bootstrap.min.css" "/css/style.css")    
    ]
   
   [:body
    [:div.container
     
     [:header {:style "padding-top: 0"}
      [:div.well
       [:h1 "Prototype " [:small "24 Feb 2012"]]
       [:p "Prototype for <span class=\"label label-info\">SEDCO</span>. Document Management & Tracking System developed by <span class=\"label label-success\">Trikom Studio</span> based on requirements/specs."]
       [:p [:span.label.label-warning "NOTICE: This is a demonstration and not a fully working system"]]
       ]]


     [:div.row
      [:div.span6.offset3
       [:div.well
        [:form.form-horizontal
         [:fieldset
          [:legend "Login to EDMS"]
          [:div.control-group
           [:label.control-label "Username"]
           [:div.controls
            [:input
             [:p.help-block "E.g tom@sedco.com"]]]]

          [:div.control-group
           [:label.control-label "Password"]
           [:div.controls
            [:input
             [:p.help-block "E.g contact administrator for inquiries on your password"]]]]

          [:div.form-actions
           [:button.btn.btn-primary {:type "submit"} "Enter"]
           "&nbsp;"
           [:button.btn "Cancel"]]
          ]] ;;form
        ]]]
     ] ;; .container
    (include-js "/js/bootstrap.min.js")]))


