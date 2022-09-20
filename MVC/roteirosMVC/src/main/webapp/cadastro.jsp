<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Cadastro</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="style.css" crossorigin="anonymous">


<!-- Bootstrap CSS v5.2.0-beta1 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>

<body>
	<!-- navbar -->
	<header>
		<nav class="navbar navbar-expand-sm navbar-dark">
			<div class="container">
				<a class="navbar-brand" href="Home.html"><img
					src="icon/world.png" width="30" height="30"
					class="d-inline-block align-text-top"> +ROTEIROS</a>
				<button class="navbar-toggler d-lg-none" type="button"
					data-bs-toggle="collapse" data-bs-target="#collapsibleNavId"
					aria-controls="collapsibleNavId" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>
			<div class="container col">
				<div class="collapse navbar-collapse" id="collapsibleNavId">
					<ul class="navbar-nav me-auto mt-2 mt-lg-0">
						<li class="nav-item"><a class="nav-link"
							href="promocoes.html">Promo&ccedil;&otilde;es</a></li>
						<li class="nav-item"><a class="nav-link" href="destino.html">Destino</a>
						</li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								Login </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="login.html">Login</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="cadastro.jsp">Cadastro</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<!-- navbar fim -->
	<section class="vh-50 bg-image">

		<div class="mask d-flex align-items-center h-100 gradient-custom-3">
			<div class="container h-100">

				<br> <br>
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-9 col-lg-9 col-xl-9">
						<div class="card" style="border-radius: 15px;">
							<div class="card-body p-5">
								<h2 class="text-uppercase text-center mb-5">Insira seus
									dados</h2>

								<form>
									<div class="form-outline mb-4">
										<input type="text" id="form3Example1cg"
											class="form-control form-control-lg" /> <label
											class="form-label" for="form3Example1cg">Nome</label>
									</div>

									<div class="form-outline mb-4">
										<input type="email" id="form3Example3cg"
											class="form-control form-control-lg" /> <label
											class="form-label" for="form3Example3cg">Email</label>
									</div>

									<div class="row">
										<div class="col form-outline mb-4">

											<input type="number" id="form3Example1cg"
												class="form-control form-control-lg" /> <label
												class="form-label" for="form3Example1cg">CPF</label>
										</div>
										<div class="col form-outline mb-4">

											<input type="tel" id="form3Example1cg"
												class="form-control form-control-lg" /> <label
												class="form-label" for="form3Example1cg">Telefone</label>
										</div>
									</div>

									<div class="form-outline mb-4">
										<input type="password" id="form3Example4cg"
											class="form-control form-control-lg" /> <label
											class="form-label" for="form3Example4cg">Senha</label>
									</div>

									<div class="form-outline mb-4">
										<input type="password" id="form3Example4cdg"
											class="form-control form-control-lg" /> <label
											class="form-label" for="form3Example4cdg">Confirme a
											sua senha</label>
									</div>

									<div class="d-flex justify-content-center">
										<button type="button" class="btn btn-lg" id="buttonLogin">Cadastrar</button>
									</div>

									<p class="text-center text-muted mt-5 mb-0">
										Já tem uma conta? <a href="login.html"
											class="fw-bold text-body"><u>Login here</u></a>
									</p>

								</form>

							</div>
						</div>
						<br> <br>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- footer começo -->
	<footer>
		<div class="container">
			<br>
			<div class="row">
				<div class="col-lg-4 col-sm-12">
					<h6>
						<img src="icon/signpost.png" width="30" height="30"
							class="d-inline-block align-text-bottom"> Institucional
					</h6>
					<ul style="list-style: none;">
						<li><a href="" class="list"> Trabalhe conosco</a></li>
						<li><a href="" class="list"> Tire sua dúvida</a></li>
						<li><a href="" class="list"> Política de privacidade</a></li>
						<li><a href="" class="list"> Mapa do site</a></li>
						<li><a href="" class="list"> Termos e condições</a></li>
					</ul>
				</div>
				<div class="col-lg-4 col-sm-12">
					<h6>
						<img src="icon/payment-method.png" width="30" height="30"
							class="d-inline-block align-text-bottom"> Formas de
						pagamento
					</h6>
					<ul style="list-style: none;">
						<li><img src="icon/mastercard.jpg" width="55" height="30"
							class="d-inline-block align-text-bottom"> Mastercard</li>
						<li><img src="icon/visa.jpg" width="55" height="30"
							class="d-inline-block align-text-bottom"> Visa</li>
						<li><img src="icon/boleto-logo.png" width="55" height="30"
							class="d-inline-block align-text-bottom"> Boleto</li>
						<li><img src="icon/pix.png" width="60" height="30"
							class="d-inline-block align-text-bottom"> Pix</li>
					</ul>
				</div>
				<div class="col-lg-4 col-sm-12 ">
					<h6>
						<img src="icon/travel-luggage.png" width="30" height="30"
							class="d-inline-block align-text-bottom"> Redes Sociais
					</h6>
					<ul style="list-style: none;">
						<li><a href="..." class="list"><img
								src="icon/facebook.png" width="30" height="30"
								class="d-inline-block align-text-bottom"> Facebook </a></li>
						<li><a href="..." class="list"><img
								src="icon/instagram.png" width="30" height="30"
								class="d-inline-block align-text-bottom"> Instagram </a></li>
						<li><a href="..." class="list"><img
								src="icon/twitter.png" width="30" height="30"
								class="d-inline-block align-text-bottom"> Twitter </a></li>
						<li><a href="..." class="list"><img
								src="icon/whatsapp.png" width="30" height="30"
								class="d-inline-block align-text-bottom"> Whatsapp </a></li>
					</ul>
				</div>
			</div>
		</div>

		</div>

	</footer>
	<!-- footer fim -->














	<!-- Bootstrap JavaScript Libraries -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
		integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
		integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
		crossorigin="anonymous"></script>

</body>

</html>