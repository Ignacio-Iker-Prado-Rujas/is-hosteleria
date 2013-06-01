format 76

classinstance 128005 class_ref 128011 // RestauranteSwing
  name ""   xyz 111 4 2000 life_line_z 2000
classinstance 128133 class_ref 142466 // Restaurante
  name ""   xyz 428 4 2000 life_line_z 2000
note 129157 "Se debe seleccionar una reserva"
  xyzwh 545 342 2000 133 55
durationcanvas 128261 classinstance_ref 128005 // :RestauranteSwing
  xyzwh 158 98 2010 11 347
end
durationcanvas 128389 classinstance_ref 128133 // :Restaurante
  xyzwh 459 98 2010 11 132
end
durationcanvas 128773 classinstance_ref 128133 // :Restaurante
  xyzwh 459 303 2010 11 143
end
msg 128517 synchronous
  from durationcanvas_ref 128261
  to durationcanvas_ref 128389
  yz 98 2015 explicitmsg "verReservas()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 364 85
msg 128645 return
  from durationcanvas_ref 128389
  to durationcanvas_ref 128261
  yz 218 2015 explicitmsg "Lista<Reserva>"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 189 204
msg 128901 synchronous
  from durationcanvas_ref 128261
  to durationcanvas_ref 128773
  yz 303 2015 explicitmsg "eliminarReserva(Reserva)"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 321 287
msg 129029 return
  from durationcanvas_ref 128773
  to durationcanvas_ref 128261
  yz 434 2015 explicitmsg "OK"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 181 422
end
