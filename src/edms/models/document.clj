(ns edms.models.document
  (:require [noir.validation :as vali])
  (:use [korma.db] [korma.core]))

;; (defdb db-mysql (mysql {:db "edms" :user "root" :password ""}))
(defdb db-postgres (postgres
                    {:db "edms"
                     :user "edms"
                     :password "edms"
                     :host "localhost"
                     :port "5432"
                     }))

(defentity documents)

(defn find-document
  [] (select documents))

;; (defentity tasks)

;; (defn project-find
;;   ([] (select projects))
;;   ([opts]
;;      (select projects
;;              (order ((opts :order) :key)
;;                     ((opts :order) :order))
;;              (limit (opts :limit))
;;              (offset (opts :offset))
;;              (where (opts :where)))))


;; ;; (project-find {:order {:key :id :order :desc}
;; ;;                :limit 3
;; ;;                :where {:id 1}})

;; (defn valid? [{:keys [code title description]}]
;;   (vali/rule (vali/has-value? code)
;;              [:code "Code required"])

;;   (vali/rule (vali/has-value? title)
;;              [:title "Title required"])

;;   (vali/rule (vali/has-value? description)
;;              [:description "Description required"])

;;   (not (vali/errors? :code :title :description)))

;; (defn create! [{:keys [code title description]}]
;;   (insert projects
;;           (values {:code code :title title :description description})))

;; (defn update! [{:keys [id code title description]}]
;;   (update projects
;;           (set-fields {:code code :title title :description description})
;;           (where {:id id})))

;; (defn delete! [id]
;;   (delete projects
;;           (where {:id id}))
;;   (delete tasks
;;           (where {:project_id id})))
