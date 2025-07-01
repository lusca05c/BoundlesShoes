    import React, { useState } from 'react';
    // Importando ícones comuns para campos de cadastro
    import { FaUser, FaEnvelope, FaLock, FaSignInAlt } from 'react-icons/fa';

    export function UserCadastro() {
        const [fullName, setFullName] = useState('');
        const [email, setEmail] = useState('');
        const [password, setPassword] = useState('');
        const [confirmPassword, setConfirmPassword] = useState('');

        const handleSubmit = (event) => {
            event.preventDefault();
            // Lógica de validação e envio do formulário
            if (password !== confirmPassword) {
                alert('A senha e a confirmação de senha não coincidem!');
                return;
            }

            console.log('Nome Completo:', fullName);
            console.log('Email:', email);
            console.log('Senha:', password);
            alert('Cadastro simulado! Verifique o console para os dados.');
            // Em um cenário real, você enviaria esses dados para uma API
            // e redirecionaria o usuário após o cadastro bem-sucedido.
        };

        return (
            <div className="min-h-screen flex items-center justify-center bg-gray-100 font-sans">
                <form onSubmit={handleSubmit} className="bg-white p-10 rounded-lg shadow-lg w-96 text-center">
                    <h2 className="text-3xl font-bold mb-8 text-gray-800">Cadastre-se</h2>
                    
                    {/* Campo Nome Completo */}
                    <div className="relative mb-6">
                        <FaUser className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400 text-xl" />
                        <input
                            type="text"
                            placeholder="Nome Completo"
                            value={fullName}
                            onChange={(e) => setFullName(e.target.value)}
                            required
                            className="w-full pl-10 pr-4 py-3 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 text-lg"
                        />
                    </div>
                    
                    {/* Campo Email */}
                    <div className="relative mb-6">
                        <FaEnvelope className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400 text-xl" />
                        <input
                            type="email"
                            placeholder="Email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            required
                            className="w-full pl-10 pr-4 py-3 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 text-lg"
                        />
                    </div>
                    
                    {/* Campo Senha */}
                    <div className="relative mb-6">
                        <FaLock className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400 text-xl" />
                        <input
                            type="password"
                            placeholder="Senha"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                            className="w-full pl-10 pr-4 py-3 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 text-lg"
                        />
                    </div>

                    {/* Campo Confirmar Senha */}
                    <div className="relative mb-8">
                        <FaLock className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400 text-xl" />
                        <input
                            type="password"
                            placeholder="Confirmar Senha"
                            value={confirmPassword}
                            onChange={(e) => setConfirmPassword(e.target.value)}
                            required
                            className="w-full pl-10 pr-4 py-3 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 text-lg"
                        />
                    </div>
                    
                    <button
                        type="submit"
                        className="w-full bg-green-600 text-white py-3 px-6 rounded-md text-xl font-semibold flex items-center justify-center gap-2 hover:bg-green-700 transition-colors duration-300 focus:outline-none focus:ring-2 focus:ring-green-500 focus:ring-offset-2"
                    >
                        <FaSignInAlt /> Cadastrar
                    </button>

                    <div className="mt-6 text-sm">
                        Já tem uma conta? <a href="/login" className="text-blue-600 hover:underline">Faça Login</a>
                    </div>
                </form>
            </div>
        );
    }