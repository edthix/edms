
(create
 edms-db
 (table
  :groups
  (integer :id :primary-key)
  (varchar :group_name 255)
  (timestamp :created_at)
  (timestamp :updated_at)))

(create
 edms-db
 (table
  :document_details
  (integer :id :primary-key)
  (integer :document_id)
  (integer :version)
  (blob :data)
  (text :ocr)
  (timestamp :created_at)
  (timestamp :updated_at)))
