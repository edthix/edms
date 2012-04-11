(ns edms.views.users
  (:require [edms.views.common :as common])
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.core :only [html]]))

;; Generate user table row in /users 
(defpartial user-row []
  [:tr
   [:td [:a {:href "#myModal" :data-toggle "modal" } 1]]
   [:td [:a {:href "#myModal" :data-toggle "modal" } "User Name"]]
   [:td [:a {:href "#myModal" :data-toggle "modal" } "user@sedco.com.my"]]
   [:td [:a {:href "#myModal" :data-toggle "modal" } "Sales"]]   
   [:td {:style "width:195px;text-align: center;"}
    [:a.btn.btn-mini {:href "#"} [:i.icon-edit] "View"]
    "&nbsp;"
    [:a.btn.btn-mini {:href "#"} [:i.icon-edit] "Edit"]
    "&nbsp;"
    [:a.btn.btn-mini.btn-danger {:href "#" :onclick "return confirm('Are you sure?');"} [:i.icon-trash] "Delete"]]]
  )


(defpage "/users" []
  (common/layout

   [:header
    [:h2 "Users"]]

   [:div.well

    [:table.table.table-bordered.table-condensed.table-striped
     [:caption "List of users"]
     [:thead
      [:tr
       [:th "ID"]
       [:th "Name"]
       [:th "Email"]
       [:th "Department"]
       [:th "&nbsp;" ]
       ]]

     [:tbody (take 10 (repeatedly user-row))]]
    ]
       
   [:div.pagination.pagination-centered
    [:ul
     [:li.active [:a {:href "#"} 1]]
     [:li [:a {:href "#"} 2]]
     ]]   
   
   )
  )

