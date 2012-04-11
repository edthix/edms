(ns lobos.migrations
  ;; exclude some clojure symbols so we can use lobos symbols
  (:refer-clojure :exclude [alter drop
                            bigint boolean char double float time])
  ;; use defmigration macro from lobos
  (:use (lobos [migration :only [defmigration]]
               core
               schema
               config)))

(defmigration add-document-details-table
  (up []
      (create edms-db
              (table :document_details
                     (integer :id :primary-key)
                     (integer :document_id)
                     (integer :version)
                     (blob :data)
                     (text :ocr)
                     (timestamp :created_at)
                     (timestamp :updated_at))))

  (down [] (drop (table :document-details))))


(defmigration add-documents-table
  (up [] (create edms-db
                 (table :documents
                        (integer :id :primary-key)
                        (varchar :index_no 255)
                        (integer :shelf_id)
                        (integer :status)
                        (timestamp :open_at)
                        (timestamp :close_at)
                        (timestamp :created_at)
                        (timestamp :updated_at))))

  (down [] (drop (table :documents))))

(defmigration add-groups-table
  (up [] (create edms-db
                 (table :groups
                        (integer :id :primary-key)
                        (varchar :group_name 255)
                        (timestamp :created_at)
                        (timestamp :updated_at))))

  (down [] (drop (table :groups))))

(defmigration add-movements-table
  (up [] (create edms-db
                 (table :movements
                        (integer :id :primary-key)
                        (integer :document_id)
                        (integer :to_user_id)
                        (text :comments))))

  (down [] (drop (table :movements))))


(defmigration add-shelfs-table
  (up [] (create edms-db
                 (table :shelfs
                        (integer :id :primary-key)
                        (varchar :shelf_name 255)
                        (timestamp :created_at)
                        (timestamp :updated_at))))

  (down [] (drop (table :shelfs))))

(defmigration add-users-table
  (up [] (create edms-db
                 (table :users
                        (integer :id :primary-key)
                        (varchar :email 255)
                        (varchar :name 255)
                        (varchar :password 255)
                        (timestamp :created_at)
                        (timestamp :updated_at))))

  (down [] (drop (table :users))))

(defmigration add-user-groups-table
  (up [] (create edms-db
                 (table :user_groups
                        (integer :id :primary-key)
                        (integer :group_id)
                        (integer :user_id)
                        (timestamp :created_at)
                        (timestamp :updated_at))))

  (down [] (drop (table :user_groups))))


;; ********************************************************************************
;; Examples
;; ********************************************************************************

;; (defmigration add-authors-table
;;   ;; code be executed when migrating the schema "up" using "migrate"
;;   (up [] (create edms-db
;;                  (table :authors (integer :id :primary-key )
;;                         (varchar :username 100 :unique )
;;                         (varchar :password 100 :not-null )
;;                         (varchar :email 255))))
;;   ;; Code to be executed when migrating schema "down" using "rollback"
;;   (down [] (drop (table :authors ))))

;; (defmigration add-posts-table
;;   (up [] (create edms-db
;;                  (table :posts (integer :id :primary-key )
;;                         (varchar :title 250)
;;                         (text :content )
;;                         (boolean :status (default false))
;;                         (timestamp :created (default (now)))
;;                         (timestamp :published )
;;                         (integer :author [:refer :authors :id] :not-null))))

;;   (down [] (drop (table :posts ))))


