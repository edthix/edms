(ns edms.views.partials
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.core :only [html]]))

(defpartial login-box []
  [:form.form-horizontal.login {:action "/documents"}
   [:fieldset
    [:legend "Login"]

    [:div.control-group
     [:label.control-label "Username / Email"]
     [:div.controls
      [:input.input-xlarge {:type "text" :value "trikom"}]]]

    [:div.control-group
     [:label.control-label "Password"]
     [:div.controls
      [:input.input-xlarge {:type "password" :value "password"}]]]
    
    [:div.form-actions
     [:button.btn.btn-primary {:type "submit"} "Login"]
     ]
    ]
   ])

(defpartial announcement-box []
  [:div.well.announcement
   [:a {:href "#" :class "close" :onclick "$('.announcement').hide();"} "&times;"]
   [:h1 "Prototype " [:small "8 Mar 2012"]]
   [:p "Prototype for <span class=\"label label-info\">SEDCO</span>. Document Management & Tracking System developed by <span class=\"label label-success\">Trikom Studio</span> based on requirements/specs."]
   [:p [:span.label.label-warning "NOTICE: This is a demonstration and not a fully working system"]]
   ]
   
)
