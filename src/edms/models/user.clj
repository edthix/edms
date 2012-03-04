(ns play_noir.models.user
  (:require [noir.session :as session]
            [noir.cookies :as cookies])
  )

(defn login [user]
  (if (and
       (= (user :username) "edthix")
       (= (user :password) "secret"))
    (session/put! :logged_in true)
    false))

(defn logout! []
  (session/clear!))


(login {:username "edthix" :password "secret"})
(session/get :logged_in)

(logout!)

(cookies/put! "logged_in" true)
