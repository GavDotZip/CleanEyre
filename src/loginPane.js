/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$('.form').find('input, textarea').on('keyup blur focus', function (e) { 
    var $this = $(this),
        label = $this.prev('label');
   
  //for transforming the text areas on each window
        if (e.type === 'keyup') {
          if ($this.val() === '') {
            label.removeClass('active highlight');
          } else {
            label.addClass('active highlight');
          }
      } else if (e.type === 'blur') {
          if( $this.val() === '' ) {
          label.removeClass('active highlight'); 
          } else {
          label.removeClass('highlight');   
          }   
      } else if (e.type === 'focus') {
        
        if( $this.val() === '' ) {
          label.removeClass('highlight'); 
          } 
        else if( $this.val() !== '' ) {
          label.addClass('highlight');
          }
      }
   
   });
   
  // for switching in between windows
  $('.tab a').on('click', function (e) {
    
    e.preventDefault();
    
    $(this).parent().addClass('active');
    $(this).parent().siblings().removeClass('active');
    
    target = $(this).attr('href');
   
    $('.tab-content > div').not(target).hide();
    
    $(target).fadeIn(600);
    
  });
  