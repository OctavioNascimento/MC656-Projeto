import { render, screen } from '@testing-library/react'
import App from './App'

test('renderiza o cabeçalho com Vite + React', () => {
  render(<App />)
  expect(screen.getByText(/UNIBIKE/i)).toBeInTheDocument()
})