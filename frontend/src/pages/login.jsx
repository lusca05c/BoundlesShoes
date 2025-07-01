import React, { useState } from 'react';
import { FaUser, FaLock, FaSignInAlt } from 'react-icons/fa';

export function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        // Lógica de autenticação
        console.log('Usuário:', username);
        console.log('Senha:', password);
        alert('Login simulado! Verifique o console para os dados.');
    };

    return (
        <div className="min-h-screen flex items-center justify-center bg-gray-100 font-sans">
            <form onSubmit={handleSubmit} className="bg-white p-10 rounded-lg shadow-lg w-96 text-center">
                <h2 className="text-3xl font-bold mb-8 text-gray-800">Login</h2>
                
                <div className="relative mb-6">
                    <FaUser className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400 text-xl" />
                    <input
                        type="text"
                        placeholder="Nome de Usuário"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                        className="w-full pl-10 pr-4 py-3 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 text-lg"
                    />
                </div>
                
                <div className="relative mb-8">
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
                
                <button
                    type="submit"
                    className="cursor-pointer w-full bg-blue-600 text-white py-3 px-6 rounded-md text-xl font-semibold flex items-center justify-center gap-2 hover:bg-blue-700 transition-colors duration-300 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2"
                >
                    <FaSignInAlt /> Entrar
                </button>

                <div className="mt-6 flex justify-between text-sm">
                    <a href="/recadastro-senha" className="text-blue-600 hover:underline">Esqueceu a senha?</a>
                    <a href="/user-cadastro" className="text-blue-600 hover:underline">Criar Conta</a>
                </div>
            </form>
        </div>
    );
}