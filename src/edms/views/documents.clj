(ns edms.views.documents
  (:require [edms.views.common :as common])
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.core :only [html]]))
(defpartial document-rows []
  [:tr
   [:td [:a {:href "/documents/1"} "00000001"]]
   [:td [:a {:href "/documents/1"} "Closed"]]
   [:td [:a {:href "/documents/1"} "Normal"]]
   [:td [:a {:href "/documents/1"} "S00001"]]
   [:td {:style "width:115px;text-align: center;"}
    [:a.btn.btn-mini {:href "#"} [:i.icon-edit] "Edit"]
    "&nbsp;"
    [:a.btn.btn-mini.btn-danger {:href "#"} [:i.icon-trash] "Delete"]]])


(defpage "/documents" []
  (common/layout
   [:div.row
    [:div.span2
     [:div.well {:style "padding: 8px 0;"}
      [:ul.nav.nav-list
       [:li.nav-header "Actions"]
       [:li [:a {:href "/documents"} "List documents"]]
       [:li [:a {:href "#"} "Add documents"]]
       [:li [:a {:href "#"} "Search"]]]
      ]
     ] ;; span2

    [:div.span10
     ;; Breadcrumb
     [:ul.breadcrumb
      [:li "Documents" [:span.divider "/"]]
      ]

     [:div.well

      [:form.form-inline
       [:select#year
          [:option {:value 2010} "2010"]
          [:option {:value 2010} "2011"]
          [:option {:value 2010} "2012"]]
       ]
      
      [:table.table.table-bordered.table-condensed.table-striped
       [:caption "List of documents for 2012"]
       [:thead
        [:tr
         [:th "File Index"]
         [:th "Status"]
         [:th "Category"]
         [:th "Shelf"]
         [:th "&nbsp;" ]
         ]]

       [:tbody (take 30 (repeatedly document-rows))]]
      ]

     [:div.pagination.pagination-centered
       [:ul
        [:li.active [:a {:href "#"} 1]]
        [:li [:a {:href "#"} 2]]
        ]]
     
     ] ;; span9
    ] ;; row   
   ))

(defpage "/documents/:id" {:keys [id]}
  (common/layout
   [:div.row
    [:div.span2
     [:div.well {:style "padding: 8px 0;"}
      [:ul.nav.nav-list
       [:li.nav-header "Actions"]
       [:li [:a {:href "#"} [:i.icon-edit]  "Edit"]]
       [:li [:a {:href "#"}  [:i.icon-trash] "Delete"]]
       [:li [:a {:href "#"}  [:i.icon-eye-close] "Close"]]
       [:li [:a {:href "#"}  [:i.icon-eye-open] "Open"]]
       ]
      ]
     ] ;; span2

    [:div.span10
     ;; Breadcrumb
     [:ul.breadcrumb
      [:li [:a {:href "/documents"} "Documents"] [:span.divider "/"]]
      [:li "Document 1"]
      ]

     [:div.row

      [:div.span5
       [:div.well
        [:h2 "File index "]
        [:p "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo."]
        ]
       ] ;; span5

      [:div.span5
       [:div.well
       [:table.table
        [:tr
         [:th "Status"]
         [:td "Closed"]
         [:th "Category"]
         [:td "Normal"]
         ]

        [:tr
         [:th "Open Date"]
         [:td "24 Feb 2012"]
         [:th "Close Date"]
         [:td "25 Feb 2012"]
         ]
        
        [:tr
         [:th "Shelf #"]
         [:td "99999-99"]
         [:th "Period"]
         [:td ""]
         ]
        ] ;; table.table
        
        ]
       ] ;; span5
      ] ;; row

     [:div.row
      [:div.span10
       [:div.well {:style "background: transparent"}
        [:h3 "Document movements "]

        [:hr ]

        [:a.btn.btn-small {:href "#"} [:i.icon-plus] " Add movement"]
        
        [:table.table
         [:caption "List of movements"]
         [:thead
          [:tr
           [:th "Date taken"]
           [:th "Taken by"]
           [:th "Date returned"]
           [:th "Return by"]
           [:th "Remarks"]]]

         ]
        ]]] ;; row
     
     ] ;; span10
    ] ;; row
   )
  )

(defpage [:get "/json"] []
  ()
  )
