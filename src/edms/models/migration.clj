(ns edms.models.migration)

;; Step 1 : Include all required lobos libraries
(use 'lobos.core 'lobos.connectivity 'lobos.config 'lobos.migration  'lobos.migrations)

;; Step 2
(open-global edms-db)
