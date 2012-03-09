(ns edms.views.welcome
  (:require [edms.views.common :as common]
            ;; [noir.content.getting-started]
            )
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.core :only [html]]
        [edms.views.partials]))




(defpage "/" []
  (common/layout

   [:header
    (announcement-box)]
   
   ;; login
   [:div.row
    [:div.span6.offset3
     (login-box)]]
   
   ))

(defpage "/welcome" []
  (common/layout
   [:p "Welcome to edms"]))
