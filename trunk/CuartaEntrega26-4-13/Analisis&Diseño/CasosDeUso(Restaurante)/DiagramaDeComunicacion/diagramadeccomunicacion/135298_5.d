format 76

classinstance 128258 class_ref 128514 // Menu
 name ""  xyz 277 127 2000
classinstance 129922 class_ref 142466 // Restaurante
 name ""  xyz 266 263 2000
classinstance 130690 class_ref 142594 // Mesa
 name ""  xyz 476 264 2000
classinstance 131202 class_ref 149122 // Comanda
 name ""  xyz 404 120 2000
linkcanvas 130818 decenter_end 446
  from ref 129922 z 2001 to ref 130690
dirscanvas 131074 z 1000 linkcanvas_ref 130818
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "1 addPedido(comanda)" xyz 347 249 3000
msgs
  explicitmsg "addPedido(comanda)"
    forward ranks 1 "1" dirscanvas_ref 131074
    no_msg
msgsend
end
