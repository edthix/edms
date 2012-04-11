(ns edms.views.welcome
  (:require [edms.views.common :as common]
            ;; [noir.content.getting-started]
            )
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.core :only [html]]
        [edms.views.partials]))


(defpage "/" []
  ^"GET / - home page"
  
  (common/layout
   (announcement-box)
   (login-box)   
   ))

(defpage "/welcome" []
  (common/layout
   [:p "Welcome to edms"]))
