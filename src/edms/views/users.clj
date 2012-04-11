(ns edms.views.users
  (:require [edms.views.common :as common])
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.core :only [html]]))

(defpage "/users/login" [user])

