format 76

classinstance 128130 class_ref 128770 // Reserva
 name ""  xyz 331 122 2000
classinstance 128386 class_ref 129026 // Factura
 name ""  xyz 524 123 2000
classinstance 129538 class_ref 142466 // Restaurante
 name ""  xyz 184 312 2000
linkcanvas 129282
  from ref 128130 z 2001 to ref 128386
dirscanvas 129410 z 1000 linkcanvas_ref 129282
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "1 imprime" xyz 428 109 3000
msgs
  explicitmsg "imprime"
    forward ranks 1 "1" dirscanvas_ref 129410
    no_msg
msgsend
end
