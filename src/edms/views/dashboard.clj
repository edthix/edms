(ns edms.views.dashboard
  (:require [edms.views.common :as common]
            [edms.views.documents])
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.core :only [html]]))

(defpartial profile-bar []
  [:div.row-fluid

   [:div.span2
    [:a {:href "#"} [:img {:src "/img/avatar.jpg" :style "width: 150px;"}]]]

   [:div.span3
    [:h2 "Tom Anderson"]

    [:p
     [:a.btn.btn-primary {:href "/dashboard/edit_profile"}
      [:i.icon-pencil "&nbsp;&nbsp;"] "Edit profile"]
     ]

    [:p
     [:a.btn.btn-primary {:href "/dashboard/change_password"}
      [:i.icon-info-sign "&nbsp;&nbsp;"] "Change password"
      ]]
    
    ]

   [:div.span3
    [:ul.nav.nav-list
     [:li.nav-header "Contact"]
     [:li [:a {:href "#"} [:i.icon-list ""] "tom@sedco.com.my"]]
     [:li [:i.icon-list "&nbsp;"] "013-8888888"]
     [:li [:i.icon-list "&nbsp;"] "088-123444 (222)"]
     [:li [:i.icon-list "&nbsp;"] "Office address 123"]
     [:li.nav-header "Department"]
     [:li [:i.icon-list "&nbsp;"] "Sales"]]    
    ]

   [:div.span3
    [:ul.nav.nav-list
     [:li.nav-header "Late documents!"]
     [:li [:i.icon-bookmark "&nbsp;"] "2 documents"]
     [:li.nav-header "Pending documents"]
     [:li [:i.icon-bookmark "&nbsp;"] "4 documents"]
     ]]   
   ]
  [:hr ]
  )

;; Change password
(defpage "/dashboard/change_password" []
  (common/layout   
   (profile-bar)
   [:div.span12
    [:div.row-fluid
     [:form.form-horizontal
      [:fieldset
       [:legend "Change password"]

       [:div.control-group
        [:label.control-label "Old password"]
        [:div.controls
         [:input.input-xlarge {:type "password"}]]]

       [:div.control-group
        [:label.control-label "New password"]
        [:div.controls
         [:input.input-xlarge {:type "password"}]]]       

       [:div.control-group
        [:label.control-label "Confirm new password"]
        [:div.controls
         [:input.input-xlarge {:type "password"}]]]       

       [:div.form-actions
        [:button.btn.btn-primary {:type "submit"} "Change password"]]]]]]))

;; Edit profile
(defpage "/dashboard/edit_profile" []
  (common/layout
   (profile-bar)
   
   [:div.span12
    [:div.row-fluid
     [:form.form-horizontal
      [:fieldset
       [:legend "Edit profile"]

       [:div.control-group
        [:label.control-label "Full name"]
        [:div.controls
         [:input.input-xlarge {:type "text" :value "Tom Anderson"}]]]

       [:div.control-group
        [:label.control-label "Email"]
        [:div.controls
         [:input.input-xlarge {:type "text" :value "tom@sedco.com.my"}]]]       

       [:div.control-group
        [:label.control-label "Telephone"]
        [:div.controls
         [:input.input-xlarge {:type "text" :value "088-123444 (222)"}]]]

       [:div.control-group
        [:label.control-label "Cellphone"]
        [:div.controls
         [:input.input-xlarge {:type "text" :value "013-8888888"}]]]              

       [:div.control-group
        [:label.control-label "Department"]
        [:div.controls
         [:input.input-xlarge {:type "text" :value "Sales"}]]]              

       [:div.control-group
        [:label.control-label "Address"]
        [:div.controls
         [:input.input-xlarge {:type "text" :value "Office address 123"}]]]              

       [:div.form-actions
        [:button.btn.btn-primary {:type "submit"} "Update"]]]]]]
   ))

;; Dashboard index
(defpage "/dashboard" []
  (common/layout

   (profile-bar)
   
   
   [:div.span12
    [:div.row-fluid

     [:header
      [:h2 "Dashboard" [:small " your personal area"]]]
     
     [:hr ]
     
     [:div.well {:style "background: #f2dede; border: 1px solid #f00"}
      [:h3 "Late documents"]

      [:table.table.table-bordered.table-condensed
       [:caption "List of late documents waiting for your actions"]

       [:thead
        [:tr
         [:th "ID"]
         [:th "File Index"]
         [:th "Status"]
         [:th "Category"]
         [:th "Shelf Number"]
         [:th "&nbsp;" ]
         ]]

       [:tbody (take 2 (repeatedly edms.views.documents/document-row))]
       ]]
     
     [:div.well
      [:h3 "Pending documents"]

      [:table.table.table-bordered.table-condensed.table-striped
       [:caption "List of pending documents waiting for your actions"]

       [:thead
        [:tr
         [:th "ID"]
         [:th "File Index"]
         [:th "Status"]
         [:th "Category"]
         [:th "Shelf Number"]
         [:th "&nbsp;" ]
         ]]

       [:tbody (take 5 (repeatedly edms.views.documents/document-row))]
       ]]
     
     
     ]] ;; span9

   
   ))
