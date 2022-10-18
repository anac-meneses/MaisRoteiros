<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="modelo.Compra" import="modelo.Login"
	import="java.util.List"%>
	
<% List<Compra> lista = (List<Compra>) request.getAttribute("lista"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Compras</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet" href="./style.css" crossorigin="anonymous">
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
				<a class="navbar-brand" href="./Home.html"><img
					src="./icon/world.png" width="30" height="30"
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
							href="./promocoes.html">Promo&ccedil;&otilde;es</a></li>
						<li class="nav-item"><a class="nav-link"
							href="./destino.html">Destino</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								Login </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="./login.html">Login</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="./cadastro.jsp">Cadastro</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>


	<section class="bg-image gradient-custom-3">

		<br> <br>
		<div class="mask d-flex align-items-center h-100 ">
			<div class="container h-100">


				<div
					class="row d-flex justify-content-center align-items-center h-100">
		
						<div class="card" style="border-radius: 15px; width: 70rem;">
							<div class="card-body p-5">
								<ul class="nav nav-tabs">
									<li class="nav-item"><a class="nav-link"
										href="./crud/compras.jsp">Cadastrar</a></li>
									<li class="nav-item"><a class="nav-link active"
										aria-current="page" href="./CompraLista">Consulta</a></li>
									<li class="nav-item"><a class="nav-link"
										href="./crud/homeADM.jsp">Home ADM</a></li>
								</ul>
								<br>

								<table class="table">
									<thead>
										<tr>
											<th>ID Compra</th>
											<th>ID Pacote</th>
											<th>CPF</th>
											<th>Quantidade</th>
											<th>Data</th>
											<th>Valor</th>
											<th>A��es</th>
										</tr>
									</thead>
								<tbody>
										<% 	for (Compra c : lista) { %>
										<tr>
											<td><%=c.getIdCompra()%></td>
											<td><%=c.idPacote()%></td>
											<td><%=c.cpf()%></td>
											<td><%=c.getQuantidade()%></td>
											<td><%=c.getDataCompra()%></td>
											<td><%=c.getValor()%></td>
											<td class="d-flex"><a
												href="./CompraUpdate?idCompra=<%=c.getIdCompra()%>"
												class="btn btn-primary">Editar</a> <a
												href="./CompraDel?idCompra=<%=c.getIdCompra()%>"
												onclick="return confirm('Deseja Excluir?')"
												class="btn btn-danger">Excluir</a></td>
										</tr>
										<% 	
										}
										%>
									</tbody>
								</table>

								<br> <br> <br>
							</div>
						</div>
					</div>
				</div>
			</div>
		
		<br> <br>

	</section>



	<!-- footer come�o -->
	<footer>
		<div class="container">
			<br>
			<div class="row">
				<div class="col-lg-4 col-sm-12">
					<h6>
						<img src="./icon/signpost.png" width="30" height="30"
							class="d-inline-block align-text-bottom"> Institucional
					</h6>
					<ul style="list-style: none;">
						<li><a href="" class="list"> Trabalhe conosco</a></li>
						<li><a href="" class="list"> Tire sua d�vida</a></li>
						<li><a href="" class="list"> Pol�tica de privacidade</a></li>
						<li><a href="" class="list"> Mapa do site</a></li>
						<li><a href="" class="list"> Termos e condi��es</a></li>
					</ul>
				</div>
				<div class="col-lg-4 col-sm-12">
					<h6>
						<img src="./icon/payment-method.png" width="30" height="30"
							class="d-inline-block align-text-bottom"> Formas de
						pagamento
					</h6>
					<ul style="list-style: none;">
						<li><img src="./icon/mastercard.jpg" width="55" height="30"
							class="d-inline-block align-text-bottom"> Mastercard</li>
						<li><img src="./icon/visa.jpg" width="55" height="30"
							class="d-inline-block align-text-bottom"> Visa</li>
						<li><img src="./icon/boleto-logo.png" width="55" height="30"
							class="d-inline-block align-text-bottom"> Boleto</li>
						<li><img src="./icon/pix.png" width="60" height="30"
							class="d-inline-block align-text-bottom"> Pix</li>
					</ul>
				</div>
				<div class="col-lg-4 col-sm-12 ">
					<h6>
						<img src="./icon/travel-luggage.png" width="30" height="30"
							class="d-inline-block align-text-bottom"> Redes Sociais
					</h6>
					<ul style="list-style: none;">
						<li><a href="..." class="list"><img
								src="./icon/facebook.png" width="30" height="30"
								class="d-inline-block align-text-bottom"> Facebook </a></li>
						<li><a href="..." class="list"><img
								src="./icon/instagram.png" width="30" height="30"
								class="d-inline-block align-text-bottom"> Instagram </a></li>
						<li><a href="..." class="list"><img
								src="./icon/twitter.png" width="30" height="30"
								class="d-inline-block align-text-bottom"> Twitter </a></li>
						<li><a href="..." class="list"><img
								src="./icon/whatsapp.png" width="30" height="30"
								class="d-inline-block align-text-bottom"> Whatsapp </a></li>
					</ul>
				</div>
			</div>
		</div>


	</footer>
	<br>
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