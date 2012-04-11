(ns lobos.config
  (:use lobos.connectivity))

;; MYSQL
;; (def edms-db
;;   {:classname "org.mysql.Driver" :subprotocol "mysql" :subname "//localhost:3306/edms"
;;    :user "root" :password ""})

;; POSTGRESQL
(def edms-db
  {:classname "org.postgresql.Driver" :subprotocol "postgresql" :subname "//localhost:5432/edms"
   :user "edms" :password "edms"})

;; (open-global edms-db)

