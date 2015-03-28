<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>	
		<script src="/assets/js/user-registration.js"></script>
		<jsp:include page="/WEB-INF/jsp/includes/assets.jsp" />			
		<title>Cadastrar Usuário</title>	
	</head>

	<body>
		<div class="container-fluid">
			<div class="row">		
				<div class ="col-xs-12 col-sm-6 col-md-8 col-lg-10 col-md-offset-1">		
					<div class="panel panel-default">
						<div class="panel-heading">
							<h1>Cadastrar Usuário</h1>
						</div>
					</div>
					
					<div class="panel-body">
						<form id="user-registration" class="form-horizontal" action="${linkTo[UserController].register}" method="post">
							<div class="form-group">
								<label for="user.login">Login:</label>
								<input type="text" id="user-login" class="form-control" name="user.login" placeholder="Digite o login desejado">
							</div>
							
							<div class="form-group">
								<label for="user.password">Senha:</label>
								<input type="password" id="user-password" class="form-control" name="user.password" placeholder="Digite a senha desejada">
							</div>
							
							<div class="form-group">
								<label for="password-validation">Repita a Senha:</label>
								<input type="password" id="user-repeated-password" class="form-control" name="password-validation" placeholder="Repita a senha digitada anteriormente">
							</div>
							
							<div class="form-group">
								<label for="user.name">Nome:</label>
								<input type="text" id="user-name" class="form-control" name="user.name" placeholder="Digite seu nome">
							</div>
							
							<div class="form-group">
								<label for="user.email">Email:</label>
								<input type="text" id="user-email" class="form-control" name="user.email" placeholder="Digite seu e-mail">
							</div>							
							
							<div class="form-group"><input type="submit" id="user-registration-submit" value="Cadastrar" class="btn btn-success btn-lg"/></div>	
						</form>
					</div>					
				</div>
			</div>
		</div>
	</body>
</html>