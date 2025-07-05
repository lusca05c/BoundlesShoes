import { useState } from 'react';
import { PageWithNavLayout } from '../layouts/PageWithNav';
import { FaEnvelope } from 'react-icons/fa';

export function RecuperarSenha() {
    const [email, setEmail] = useState('');
    const [message, setMessage] = useState('');
    const [error, setError] = useState('');
    const [isLoading, setIsLoading] = useState(false);

    const handleSubmit = async (e) => {
        e.preventDefault();
        setMessage('');
        setError('');
        setIsLoading(true);

        try {
            // **IMPORTANTE:** Substitua '/api/forgot-password' pela URL real do seu endpoint de backend
            const response = await fetch('SUA_URL_DA_API_DE_ESQUECEU_SENHA', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ email }),
            });

            if (response.ok) {
                setMessage('Email válido, estamos redirecionando...');
                setEmail('');
            } else {
                const errorData = await response.json();
                setError(errorData.message || 'Não foi possível processar sua solicitação. Por favor, tente novamente.');
            }
        } catch (err) {
            console.error('Erro na requisição:', err);
            setError('Não foi possível conectar ao servidor. Verifique sua conexão ou tente mais tarde.');
        } finally {
            setIsLoading(false);
        }
    };

    return (
        <PageWithNavLayout hideSearchBar={true} hideCategoryMenu={true}>
            <div className="bg-gray-100 flex items-center justify-center w-full h-full p-4">
                <div className="bg-white p-8 rounded-lg shadow-lg w-full max-w-md text-center">
                    <h2 className="text-2xl font-bold mb-6 text-gray-800">Esqueceu a Senha?</h2>
                    <p className="text-gray-600 mb-6 text-sm md:text-base">
                        Informe seu e-mail para redefinir sua senha.
                    </p>
                    <form onSubmit={handleSubmit}>
                        <div className="mb-4 relative">
                            <label htmlFor="email" className="block text-gray-700 text-sm font-bold mb-2 text-left">
                                E-mail
                            </label>
                            <FaEnvelope className="absolute left-3 top-1/2 mt-2 transform -translate-y-1/2 text-gray-400 text-lg" />
                            <input
                                type="email"
                                id="email"
                                className="shadow appearance-none border rounded w-full py-2 px-3 pl-10 text-gray-700 leading-tight focus:outline-none focus:ring-2 focus:ring-blue-500 focus:shadow-outline"
                                placeholder="seu@email.com"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                                required
                                disabled={isLoading}
                            />
                        </div>
                        {message && <p className="text-green-600 text-sm mb-4">{message}</p>}
                        {error && <p className="text-red-600 text-sm mb-4">{error}</p>}
                        <button
                            type="submit"
                            className="cursor-pointer bg-blue-600 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2 w-full transition-colors duration-300"
                            disabled={isLoading}
                        >
                            {isLoading ? 'Enviando...' : 'Enviar Link de Redefinição'}
                        </button>
                    </form>
                    <div className="mt-6 text-sm">
                        <a href="/login" className="text-blue-600 hover:underline">Lembrou da senha? Voltar ao Login</a>
                    </div>
                </div>
            </div>
        </PageWithNavLayout>
    );
}