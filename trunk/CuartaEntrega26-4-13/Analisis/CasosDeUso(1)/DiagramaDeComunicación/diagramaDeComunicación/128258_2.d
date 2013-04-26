format 76

classinstance 128002 class_ref 128130 // Plato
 name ""  xyz 307 149 2000
classinstance 128386 class_ref 128258 // PestanaRestaurante
 name ""  xyz 67 310 2000
classinstance 128514 class_ref 128514 // Menu
 name ""  xyz 305 310 2000
classinstance 128642 class_ref 128642 // ListaPlatos
 name ""  xyz 293 434 2000
linkcanvas 129026
  from ref 128386 z 2001 to ref 128514
dirscanvas 129154 z 1000 linkcanvas_ref 129026
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "1 modificarMenu" xyz 198 297 3000
linkcanvas 129538
  from ref 128514 z 2001 to ref 128002
dirscanvas 129666 z 1000 linkcanvas_ref 129538
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "2 añadirPlato
3 modificarPlato" xyz 229 233 3000
  backward_label "4 nuevoPlato" xyz 341 241 3000
linkcanvas 129794
  from ref 128514 z 2001 to ref 128642
dirscanvas 129922 z 1000 linkcanvas_ref 129794
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "5 borrarPlato
6 modifica" xyz 341 377 3000
msgs
  explicitmsg "modificarMenu"
    forward ranks 1 "1" dirscanvas_ref 129154
    msgs
      explicitmsg "añadirPlato"
	forward ranks 2 "1.1" dirscanvas_ref 129666
	no_msg
      explicitmsg "modificarPlato"
	forward ranks 3 "1.2" dirscanvas_ref 129666
	no_msg
    msgsend
  explicitmsg "nuevoPlato"
    backward ranks 4 "2" dirscanvas_ref 129666
    msgs
      explicitmsg "borrarPlato"
	forward ranks 5 "2.1" dirscanvas_ref 129922
	no_msg
      explicitmsg "modifica"
	forward ranks 6 "2.2" dirscanvas_ref 129922
	no_msg
    msgsend
msgsend
end
