import { render, screen } from '@testing-library/react'
import App from './src/App'

test('renderiza o cabeçalho com Vite + React', () => {
  render(<App />)
  expect(screen.getByText(/Vite \+ React/i)).toBeInTheDocument()
})