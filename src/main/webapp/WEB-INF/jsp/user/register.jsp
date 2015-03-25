<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="/assets/css/bootstrap/css/bootstrap.css" rel="stylesheet">
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
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
						<form class="form-horizontal">
							<div class="form-group">
								<label>Login:</label>
								<input type="text" class="form-control" placeholder="Digite o login desejado">
							</div>
							
							<div class="form-group">
								<label>Senha:</label>
								<input type="password" class="form-control" placeholder="Digite a senha desejada">
							</div>
							
							<div class="form-group">
								<label>Nome:</label>
								<input type="text" class="form-control" placeholder="Digite seu nome">
							</div>
							
							<div class="form-group">
								<label>Email:</label>
								<input type="text" class="form-control" placeholder="Digite seu e-mail">
							</div>							
							
							<div class="form-group"><input type="submit" value="Cadastrar" class="btn btn-success btn-lg"/></div>	
						</form>
					</div>					
				</div>
			</div>
		</div>
	</body>
</html>