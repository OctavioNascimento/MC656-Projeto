import { render, screen } from '@testing-library/react'
import Login from './Login'

test('Should render a button with text "LOGIN"', () => {
     render(<Login />)
     expect(screen.getByText("Gerencie seu usuário e senha única, acessar o Portal da Senha UNICAMP")).toBeInTheDocument()
})
