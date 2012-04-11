(ns edms.views.partials
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.core :only [html]])
  (import java.util.Date))

(defpartial login-box []
  ^"Render inline login box"
  
  [:h2 "Login"]
  [:hr]
  
   [:form.form-inline {:action "/documents" :method "GET"} 
    [:input.input-large {:type "text" :placeholder "username"}] "&nbsp;&nbsp;"
    [:input.input-large {:type "password" :placeholder "password"}] "&nbsp;&nbsp;"
    [:label.checkbox [:input {:type "checkbox"}] "Remember me"] "&nbsp;&nbsp;"
    [:button.btn.btn-primary {:type "submit"} "Sign in"]
    ]
  )

(defpartial announcement-box []
  [:div.hero-unit.announcement
   [:a {:href "#" :class "close" :onclick "$('.announcement').hide();"} "&times;"]
   [:h1 "Prototype " [:small (new Date)]]
   
   [:p "Prototype for <span class=\"label label-info\">SEDCO</span>."]

   [:p "Document Management & Tracking System developed by <span class=\"label label-success\">Trikom Studio</span> based on requirements/specs."]
   
   [:p [:span.label.label-warning "NOTICE: This is a demonstration and not a fully working system"]]
   
   ])
