(ns lobos.config
  (:use lobos.connectivity))

(def edms-db
  {
   :classname "org.mysql.Driver"
   :subprotocol "mysql"
   :subname "edms"
   :user "root"
   :password ""})

(open-global edms-db)
