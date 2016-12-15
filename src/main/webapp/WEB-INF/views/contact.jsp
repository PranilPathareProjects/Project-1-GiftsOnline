<jsp:include page="commonHeader.jsp"></jsp:include>
	<div class="container" style="padding-bottom:10px">
		<div class="row">
			<h2 align="center">Contact GiftsOnline</h2>
			<p align="center">In case of any queries, suggestions, please feel free to call us or mail us using the following:</p>
			<div class="col-md-6 col-lg-6">
				<h3>Our Location:</h3>
				<span class="glyphicon glyphicon-map-marker pull-left"></span>
				<address style="margin-left: 20px"><b>GiftsOnline Pvt. Ltd.</b>,<br>
				Near Fellowship School,<br>
				Grant Road (West),<br>
				Mumbai - 400034.</address>
				<h3>Our Contact Numbers:</h3>
				<span class="glyphicon glyphicon-phone-alt pull-left"></span><p style="margin-left: 20px">+91-22-12345678</p>
				<span class="glyphicon glyphicon-phone pull-left"></span><p style="margin-left: 20px">+91-1234567891</p>
				<h3>Our Email:</h3>
				<span class="glyphicon glyphicon-envelope pull-left"></span>
				<p style="margin-left: 20px">mail@giftsonline.com</p>
			</div>
			<div class="col-md-6 col-lg-6">
				<form>
					<div class="form-group">
						<label for="name">Name:</label>
						<input type="text" class="form-control" id="name" placeholder="Enter Your Name" required="required">
					</div>
					<div class="form-group">
						<label for="email">Email:</label>
						<input type="email" class="form-control" id="email" placeholder="Enter Your Email" required="required">
					</div>
					<div class="form-group">
						<label for="comment">Comments:</label>
						<textarea rows="9" class="form-control" id="comment" placeholder="Enter Your Comments Here..." required="required"></textarea>
					</div>
					<button type="button" class="btn btn-primary btn-block" href="#">Send Message</button>
				</form>	
			</div>
		</div>
	</div>
<jsp:include page="commonFooter.jsp"></jsp:include>