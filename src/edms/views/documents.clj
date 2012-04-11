(ns edms.views.documents
  (:require [edms.views.common :as common])
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.core :only [html]]))

;; Variables
(def file-index "1001/001PT.04")
(def status-closed "Closed")
(def status-opened "Opened")
(def category-normal "Normal")
(def shelf-number "K/D(R/1-1)")
(def file-description "FILE DESCRIPTION")
(def date-of-open "24 Jan 2012")
(def date-of-close "31 Mar 2012")
(def length-of-stored-period "27 Feb 2012")
(def file-number 491)
 
(defpartial document-row []
  [:tr
   [:td [:a {:href "#myModal" :data-toggle "modal" } file-index]]
   [:td [:a {:href "#myModal" :data-toggle "modal" } status-closed]]
   [:td [:a {:href "#myModal" :data-toggle "modal" } category-normal]]
   [:td [:a {:href "#myModal" :data-toggle "modal"} shelf-number]]
   [:td {:style "width:195px;text-align: center;"}
    [:a.btn.btn-mini {:href "/documents/1"} [:i.icon-edit] "View"]
    "&nbsp;"
    [:a.btn.btn-mini {:href "#"} [:i.icon-edit] "Edit"]
    "&nbsp;"
    [:a.btn.btn-mini.btn-danger {:href "#" :onclick "return confirm('Are you sure?');"} [:i.icon-trash] "Delete"]]]
  )

(defpartial document-movement-row []
  [:tr
   [:td "1 Jan 2012"]
   [:td [:a {:href "#"} "User 1"]]
   [:td "31 Jan 2012"]
   [:td [:a {:href "#"} "User 1"]]
   [:td "Document remarks go here ...."]]
  )

(defpartial document-modal []
  [:div.modal.fade {:id "myModal"}
   [:div.modal-header
    [:a.close {:data-dismiss "modal"} "x"]
    [:h3 "Preview document"]]
   [:div.modal-boy

    [:div.span7
     [:div.wells
      [:table.table
       [:tr
        [:th "Status"]
        [:td status-closed]
        [:th "Category"]
        [:td category-normal]
        ]

       [:tr
        [:th "Open Date"]
        [:td date-of-open]
        [:th "Close Date"]
        [:td date-of-close]]
       
       [:tr
        [:th "Shelf #"]
        [:td shelf-number]
        [:th "Period"]
        [:td length-of-stored-period]]
       ] ;; table.table       
      ]
     ] ;; span5     
    ]
   [:div.modal-footer
    [:a.btn.btn-mini {:href "/documents/1"} "View document"]]])

(defpartial document-movement-modal []
  [:div.modal.fade {:id "myMovementModal"}
   [:div.modal-header
    [:a.close {:data-dismiss "modal"} "x"]
    [:h3 "Document movement"]]
   [:div.modal-boy

    [:div.span4
     [:div.wells
      [:form.form-horizontal
       [:fieldset
        [:legend ""]
        [:div.control-group
         [:label.control-label "Date taken"]
         [:div.controls
          [:input.input-xlarge {:type "text"}]]]

        [:div.control-group
         [:label.control-label "Taken by"]
         [:div.controls
          [:input.input-xlarge {:type "text"}]]]        

        [:div.control-group
         [:label.control-label "Date returned"]
         [:div.controls
          [:input.input-xlarge {:type "text"}]]]

        [:div.control-group
         [:label.control-label "Return by"]
         [:div.controls
          [:input.input-xlarge {:type "text"}]]]

        [:div.control-group
         [:label.control-label "Remarks"]
         [:div.controls
          [:textarea.input-xlarge {:rows 5}]]]
        ]

       [:div.form-actions
        [:button.btn.btn-mini.btn-primary {:type "submit"} "Add"]]
       ]
      ]
     ] ;; span5     
    ]
   [:div.modal-footer
    
    ]])

(defpartial sidebar []
  [:div.span2
   [:div.row
    [:div.span2
     [:div.well {:style "padding: 8px 0;"}
      [:ul.nav.nav-list
       [:li.nav-header "User"]
       [:li [:a {:href "/users/1"} [:img {:src "/img/100x100.gif"}]]]
       [:li [:a {:href "/users/1"} [:i.icon-user] " Demo User"]]
       [:li [:a {:href "/users/1/edit"} [:i.icon-pencil] " Preferences"]]
       [:li [:a {:href "/logout"} [:i.icon-exclamation-sign] " Search"]]
       [:li [:a {:href "/logout"} [:i.icon-off] " Logout"]]]
      
      ]
     ] ;; span2

    [:div.span2
     [:div.well {:style "padding: 8px 0;"}
      [:ul.nav.nav-list
       [:li.nav-header "Management"]
       [:li [:a {:href "/documents"} [:i.icon-th-list] " List"]]
       [:li [:a {:href "/documents/add"} [:i.icon-plus-sign] " Add"]]
       [:li [:a {:href "/documents/search"} [:i.icon-search] " Search"]]]
      ]
     ] ;; span2
    ]] ;; span2
  )

(defpage "/documents" []
  ^"GET /documents. List documents by year and paginated"

  (common/layout
   
   [:header
    [:h2 "Documents" [:small " archive of files based on year"]]]

   ;; Breadcrumb
   [:ul.breadcrumb
    [:li "Documents" [:span.divider "/"]]
    ]

   [:div.well

    [:form.form-inline
     [:select#year
      [:option {:value 2012} "2012"]
      [:option {:value 2011} "2011"]
      [:option {:value 2010} "2010"]
      ]
     ]
    
    [:table.table.table-bordered.table-condensed.table-striped
     [:caption "List of documents for 2012"]
     [:thead
      [:tr
       [:th "File Index"]
       [:th "Status"]
       [:th "Category"]
       [:th "Shelf Number"]
       [:th "&nbsp;" ]
       ]]

     [:tbody (take 10 (repeatedly document-row))]]
    ]

   [:div.pagination.pagination-centered
    [:ul
     [:li.active [:a {:href "#"} 1]]
     [:li [:a {:href "#"} 2]]
     ]]
   (document-modal)))

(defpage "/documents/:id" {:keys [id]}
  (common/layout
   [:header
    [:h2 "Document info" [:small ""]]]
   
   [:div.row
    (sidebar)

    [:div.span10
     ;; Breadcrumb
     [:ul.breadcrumb
      [:li [:a {:href "/documents"} "Documents"] [:span.divider "/"]]
      [:li "Document 1"]
      ]

     [:div.row
      
      [:div.span10
       [:div.well
        [:h2 file-index [:small "&nbsp;" file-number ]]
        [:p "DESCRIPTION"]
        ]
       ] ;; span5

      [:div.span10
       [:div.well
        [:table.table
         [:tr
          [:th "Status"]
          [:td status-closed]
          [:th "Category"]
          [:td category-normal]
          ]

         [:tr
          [:th "Open Date"]
          [:td date-of-open]
          [:th "Close Date"]
          [:td date-of-close]]
         
         [:tr
          [:th "Shelf #"]
          [:td shelf-number]
          [:th "Period"]
          [:td length-of-stored-period]]
         ] ;; table.table       
        ]
       ] ;; span5

      
      ] ;; row

     [:div.row
      [:div.span10
       [:div.well {:style "background: transparent"}
        [:h3 "Document movements "]

        [:hr ]

        (document-movement-modal)
        [:a.btn.btn-small {:href "#myMovementModal" :data-toggle "modal" } [:i.icon-plus] " Add movement"]
        
        [:table.table
         [:caption "List of movements"]
         [:thead
          [:tr
           [:th "Date taken"]
           [:th "Taken by"]
           [:th "Date returned"]
           [:th "Return by"]
           [:th "Remarks"]]]
         [:tbody
          (take 5 (repeatedly document-movement-row))
          ]
         ]
        ]]] ;; row
     
     ] ;; span10
    ] ;; row
   )
  )

(defpage "/documents/add" []
  (common/layout
   [:header
    [:h2 "New document" [:small ""]]]
   
   [:div.row
    (sidebar)

    [:div.span10
     ;; Breadcrumb
     [:ul.breadcrumb
      [:li [:a {:href "/documents"} "Documents"] [:span.divider "/"]]
      [:li "Add document"]
      ]

     [:div.row
      [:div.span10
       
       [:form.form-horizontal {:action "/documents/1"}
        [:fieldset
         [:legend "Add a new document"]

         [:div.control-group
          [:label.control-label "File index"]
          [:div.controls
           [:input.input-xlarge {:type "text"}]]]

         [:div.control-group
          [:label.control-label "Number"]
          [:div.controls
           [:input.input-xlarge {:type "text"}]]]        
         
         [:div.control-group
          [:label.control-label "Status"]
          [:div.controls
           [:label.checkbox
            [:input {:type "checkbox"}] "Open"]
           ]]

         [:div.control-group
          [:label.control-label "Category"]
          [:div.controls
           [:select
            [:option "Normal"]
            [:option "Urgent"]]]]

         [:div.control-group
          [:label.control-label "Shelf number"]
          [:div.controls
           [:select
            [:option shelf-number]
            [:option shelf-number]
            [:option shelf-number]]]]
         
         [:div.control-group
          [:label.control-label "Open date"]
          [:div.controls
           [:input.input-xlarge {:type "text"}]]]        

         [:div.control-group
          [:label.control-label "Close date"]
          [:div.controls
           [:input.input-xlarge {:type "text"}]]]        

         
         [:div.control-group
          [:label.control-label "Description"]
          [:div.controls
           [:textarea.input-xlarge {:rows 5}]]]
         ]

        [:div.form-actions
         [:button.btn.btn-large.btn-primary {:type "submit"} "Save"]]
        ]       
       ]] ;; row
     
     ] ;; span10
    ] ;; row
   )
  )

